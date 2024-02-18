import pygame
from pygame.locals import *
from pygame import mixer
import pickle
from os import path

pygame.mixer.pre_init(44100, -16, 2, 512)
mixer.init()
pygame.init()

clock = pygame.time.Clock()
fps = 60






#define font
font = pygame.font.SysFont('Bauhaus 93', 70)
font_score = pygame.font.SysFont('Bauhaus 93', 30)


#define game variables
tile_size = 50
game_over = 0
main_menu = True
level = 1
max_levels = 7
score = 0
screen_width = tile_size*20
screen_height = screen_width

screen = pygame.display.set_mode((screen_width, screen_height))
pygame.display.set_caption('Hackathon')

#define colours
white = (255, 255, 255)
blue = (0, 0, 255)


#load images
bg_hackathon1 = pygame.image.load('hackathon1/space4.png')
restart_hackathon1 = pygame.image.load('hackathon1/restart_btn.png')
start_hackathon1 = pygame.image.load('hackathon1/start10.png')
exit_hackathon1 = pygame.image.load('hackathon1/exit4.png')

#load sounds
pygame.mixer.music.load('hackathon1/Run-Amok(chosic.com).mp3')
pygame.mixer.music.play(-1, 0.0, 5000)
coin_fx = pygame.mixer.Sound('hackathon1/coin.wav')
coin_fx.set_volume(0.5)
jump_fx = pygame.mixer.Sound('hackathon1/jump.wav')
jump_fx.set_volume(0.5)
game_over_fx = pygame.mixer.Sound('hackathon1/game_over.wav')
game_over_fx.set_volume(0.5)


def draw_text(text, font, text_col, x, y):
	hackathon1 = font.render(text, True, text_col)
	screen.blit(hackathon1, (x, y))


#function to reset level
def reset_level(level):
	player.reset(100, screen_height - 130)
	blob_group.empty()
	platform_group.empty()
	coin_group.empty()
	lava_group.empty()
	exit_group.empty()

	#load in level data and create world
	if path.exists(f'level{level}_data'):
		pickle_in = open(f'level{level}_data', 'rb')
		world_data = pickle.load(pickle_in)
	world = World(world_data)
	#create dummy coin for showing the score
	score_coin = Coin(tile_size // 2, tile_size // 2)
	coin_group.add(score_coin)
	return world


class Button():
	def __init__(self, x, y, image):
		self.image = image
		self.rect = self.image.get_rect()
		self.rect.x = x
		self.rect.y = y
		self.clicked = False

	def draw(self):
		action = False

		#get mouse position
		pos = pygame.mouse.get_pos()

		#check mouseover and clicked conditions
		if self.rect.collidepoint(pos):
			if pygame.mouse.get_pressed()[0] == 1 and self.clicked == False:
				action = True
				self.clicked = True

		if pygame.mouse.get_pressed()[0] == 0:
			self.clicked = False


		#draw button
		screen.blit(self.image, self.rect)

		return action


class Player():
	def __init__(self, x, y):
		self.reset(x, y)

	def update(self, game_over):
		delta_x = 0
		delta_y = 0
		walk_cooldown = 5
		col_thresh = 20

		if game_over == 0:
			#get keypresses
			key = pygame.key.get_pressed()
			if key[pygame.K_SPACE] and self.jumped == False and self.in_air == False:
				jump_fx.play()
				self.vel_y = -15
				self.jumped = True
			if key[pygame.K_SPACE] == False:
				self.jumped = False
			if key[pygame.K_LEFT]:
				delta_x -= 5
				self.counter += 1
				self.direction = -1
			if key[pygame.K_RIGHT]:
				delta_x += 5
				self.counter += 1
				self.direction = 1
			if key[pygame.K_LEFT] == False and key[pygame.K_RIGHT] == False:
				self.counter = 0
				self.index = 0
				if self.direction == 1:
					self.image = self.images_right[self.index]
				if self.direction == -1:
					self.image = self.images_left[self.index]


			#handle animation
			if self.counter > walk_cooldown:
				self.counter = 0	
				self.index += 1
				if self.index >= len(self.images_right):
					self.index = 0
				if self.direction == 1:
					self.image = self.images_right[self.index]
				if self.direction == -1:
					self.image = self.images_left[self.index]


			#add gravity
			self.vel_y += 1
			if self.vel_y > 10:
				self.vel_y = 10
			delta_y += self.vel_y

			#check for collision
			self.in_air = True
			for tile in world.tile_list:
				#check for collision in x direction
				if tile[1].colliderect(self.rect.x + delta_x, self.rect.y, self.width, self.height):
					delta_x = 0
				#check for collision in y direction
				if tile[1].colliderect(self.rect.x, self.rect.y + delta_y, self.width, self.height):
					#check if below the ground i.e. jumping
					if self.vel_y < 0:
						delta_y = tile[1].bottom - self.rect.top
						self.vel_y = 0
					#check if above the ground i.e. falling
					elif self.vel_y >= 0:
						delta_y = tile[1].top - self.rect.bottom
						self.vel_y = 0
						self.in_air = False


			#check for collision with enemies
			if pygame.sprite.spritecollide(self, blob_group, False):
				game_over = -1
				game_over_fx.play()

			#check for collision with lava
			if pygame.sprite.spritecollide(self, lava_group, False):
				game_over = -1
				game_over_fx.play()

			#check for collision with exit
			if pygame.sprite.spritecollide(self, exit_group, False):
				game_over = 1


			#check for collision with platforms
			for platform in platform_group:
				#collision in the x direction
				if platform.rect.colliderect(self.rect.x + delta_x, self.rect.y, self.width, self.height):
					delta_x = 0
				#collision in the y direction
				if platform.rect.colliderect(self.rect.x, self.rect.y + delta_y, self.width, self.height):
					#check if below platform
					if abs((self.rect.top + delta_y) - platform.rect.bottom) < col_thresh:
						self.vel_y = 0
						delta_y = platform.rect.bottom - self.rect.top
					#check if above platform
					elif abs((self.rect.bottom + delta_y) - platform.rect.top) < col_thresh:
						self.rect.bottom = platform.rect.top - 1
						self.in_air = False
						delta_y = 0
					#move sideways with the platform
					if platform.move_x != 0:
						self.rect.x += platform.move_direction


			#update player coordinates
			self.rect.x += delta_x
			self.rect.y += delta_y


		elif game_over == -1:
			self.image = self.dead_image
			draw_text('GAME OVER!', font, blue, (screen_width // 2) - 200, screen_height // 2)
			if self.rect.y > 200:
				self.rect.y -= 5

		#draw player onto screen
		screen.blit(self.image, self.rect)

		return game_over


	def reset(self, x, y):
		self.images_right = []
		self.images_left = []
		self.index = 0
		self.counter = 0
		for num in range(1, 5):
			hackathon1_right = pygame.image.load('hackathon1/character.png')
			hackathon1_right = pygame.transform.scale(hackathon1_right, (30, 60))
			hackathon1_left = pygame.transform.flip(hackathon1_right, True, False)
			self.images_right.append(hackathon1_right)
			self.images_left.append(hackathon1_left)
		self.dead_image = pygame.image.load('hackathon1/jerry.png')
		self.image = self.images_right[self.index]
		self.rect = self.image.get_rect()
		self.rect.x = x
		self.rect.y = y
		self.width = self.image.get_width()
		self.height = self.image.get_height()
		self.vel_y = 0
		self.jumped = False
		self.direction = 0
		self.in_air = True



class World():
	def __init__(self, data):
		self.tile_list = []

		#load images
		dirt_hackathon1 = pygame.image.load('hackathon1/block2.png')
		grass_hackathon1 = pygame.image.load('hackathon1/block2.png')

		row_count = 0
		for row in data:
			col_count = 0
			for tile in row:
				if tile == 1:
					hackathon1 = pygame.transform.scale(dirt_hackathon1, (tile_size, tile_size))
					hackathon1_rect = hackathon1.get_rect()
					hackathon1_rect.x = col_count * tile_size
					hackathon1_rect.y = row_count * tile_size
					tile = (hackathon1, hackathon1_rect)
					self.tile_list.append(tile)
				if tile == 2:
					hackathon1 = pygame.transform.scale(grass_hackathon1, (tile_size, tile_size))
					hackathon1_rect = hackathon1.get_rect()
					hackathon1_rect.x = col_count * tile_size
					hackathon1_rect.y = row_count * tile_size
					tile = (hackathon1, hackathon1_rect)
					self.tile_list.append(tile)
				if tile == 3:
					blob = Enemy(col_count * tile_size, row_count * tile_size + 15)
					blob_group.add(blob)
				if tile == 4:
					platform = Platform(col_count * tile_size, row_count * tile_size, 1, 0)
					platform_group.add(platform)
				if tile == 5:
					platform = Platform(col_count * tile_size, row_count * tile_size, 0, 1)
					platform_group.add(platform)
				if tile == 6:
					lava = Lava(col_count * tile_size, row_count * tile_size + (tile_size // 2))
					lava_group.add(lava)
				if tile == 7:
					coin = Coin(col_count * tile_size + (tile_size // 2), row_count * tile_size + (tile_size // 2))
					coin_group.add(coin)
				if tile == 8:
					exit = Exit(col_count * tile_size, row_count * tile_size - (tile_size // 2))
					exit_group.add(exit)
				col_count += 1
			row_count += 1


	def draw(self):
		for tile in self.tile_list:
			screen.blit(tile[0], tile[1])



class Enemy(pygame.sprite.Sprite):
	def __init__(self, x, y):
		pygame.sprite.Sprite.__init__(self)
		self.image = pygame.image.load('hackathon1/blob.png')
		self.rect = self.image.get_rect()
		self.rect.x = x
		self.rect.y = y
		self.move_direction = 1
		self.move_counter = 0

	def update(self):
		self.rect.x += self.move_direction
		self.move_counter += 1
		if abs(self.move_counter) > 50:
			self.move_direction *= -1
			self.move_counter *= -1


class Platform(pygame.sprite.Sprite):
	def __init__(self, x, y, move_x, move_y):
		pygame.sprite.Sprite.__init__(self)
		hackathon1 = pygame.image.load('hackathon1/block2.png')
		self.image = pygame.transform.scale(hackathon1, (tile_size, tile_size // 2))
		self.rect = self.image.get_rect()
		self.rect.x = x
		self.rect.y = y
		self.move_counter = 0
		self.move_direction = 1
		self.move_x = move_x
		self.move_y = move_y


	def update(self):
		self.rect.x += self.move_direction * self.move_x
		self.rect.y += self.move_direction * self.move_y
		self.move_counter += 1
		if abs(self.move_counter) > 50:
			self.move_direction *= -1
			self.move_counter *= -1





class Lava(pygame.sprite.Sprite):
	def __init__(self, x, y):
		pygame.sprite.Sprite.__init__(self)
		hackathon1 = pygame.image.load('hackathon1/trap.png')
		self.image = pygame.transform.scale(hackathon1, (tile_size, tile_size // 2))
		self.rect = self.image.get_rect()
		self.rect.x = x
		self.rect.y = y


class Coin(pygame.sprite.Sprite):
	def __init__(self, x, y):
		pygame.sprite.Sprite.__init__(self)
		hackathon1 = pygame.image.load('hackathon1/planet.png')
		self.image = pygame.transform.scale(hackathon1, (tile_size // 2, tile_size // 2))
		self.rect = self.image.get_rect()
		self.rect.center = (x, y)


class Exit(pygame.sprite.Sprite):
	def __init__(self, x, y):
		pygame.sprite.Sprite.__init__(self)
		hackathon1 = pygame.image.load('hackathon1/exit.png')
		self.image = pygame.transform.scale(hackathon1, (tile_size, int(tile_size * 1.5)))
		self.rect = self.image.get_rect()
		self.rect.x = x
		self.rect.y = y



player = Player(100, screen_height - 100)

blob_group = pygame.sprite.Group()
platform_group = pygame.sprite.Group()
lava_group = pygame.sprite.Group()
coin_group = pygame.sprite.Group()
exit_group = pygame.sprite.Group()

#create dummy coin for showing the score
score_coin = Coin(tile_size // 2, tile_size // 2)
coin_group.add(score_coin)

#load in level data and create world
if path.exists(f'level{level}_data'):
	pickle_in = open(f'level{level}_data', 'rb')
	world_data = pickle.load(pickle_in)
world = World(world_data)


#create buttons
restart_button = Button(screen_width // 2 - 50, screen_height // 2 + 100, restart_hackathon1)
start_button = Button(screen_width // 2 - 350, screen_height // 2, start_hackathon1)
exit_button = Button(screen_width // 2 + 150, screen_height // 2, exit_hackathon1)

#Game loop
run = True
while run:

	clock.tick(fps)

	screen.blit(bg_hackathon1, (0, 0))

	if main_menu == True:
		if exit_button.draw():
			run = False
		if start_button.draw():
			main_menu = False
	else:
		world.draw()

		if game_over == 0:
			blob_group.update()
			platform_group.update()
			#update score
			#check if a coin has been collected
			if pygame.sprite.spritecollide(player, coin_group, True):
				score += 1
				coin_fx.play()
			draw_text('X ' + str(score), font_score, white, tile_size - 10, 10)
		
		blob_group.draw(screen)
		platform_group.draw(screen)
		lava_group.draw(screen)
		coin_group.draw(screen)
		exit_group.draw(screen)

		game_over = player.update(game_over)

		#if player has died
		if game_over == -1:
			if restart_button.draw():
				world_data = []
				world = reset_level(level)
				game_over = 0
				score = 0

		#if player has completed the level
		if game_over == 1:
			#reset game and go to next level
			level += 1
			if level <= max_levels:
				#reset level
				world_data = []
				world = reset_level(level)
				game_over = 0
			else:
				draw_text('YOU WIN!', font, blue, (screen_width // 2) - 140, screen_height // 2)
				if restart_button.draw():
					level = 1
					#reset level
					world_data = []
					world = reset_level(level)
					game_over = 0
					score = 0

	for event in pygame.event.get():
		if event.type == pygame.QUIT:
			run = False

	pygame.display.update()

pygame.quit()
