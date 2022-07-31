# -------------------------------------------

score = [95, 88, 72, 86, 92, 63, 80, 91]
print(score)


# -------------------------------------------

# number <- input
# if (number MOD 3 = 0){
#     display ("multiple of 3")
# }
# else{
#     display ("not a multiple of 3")
# }


# num1 <-input
# num2 <-input
# sum <- num1 + num2
# if (sum > 100){
#     display (100)
# }

# else{
#     display(sum)
# }


# display ( is cert)
# have cert <- input ()
# display (years)
# year <- input
# salary <- 35000

# if (with cert)
# {
#     if ( year < 10)
#     {
#         salary <- salary + 10000
#     }

#     else ( year > 10)
#     {
#         salary <- salary + 15000
#     }
# }


# --------------------------------

# repeat umtil(goal)
# {
#     move forward
#     rotate right
#     move forward
#     rotate left
# }


# ------------------------------------
# nums <- [8, 2, 3, 5, 7, 9]
# sum <- 0
# for each score in num:
# {
#     if(score MOD 2 = 0)
#     {
#         sum <- sum + score
#     }
# }
# display {num}

#----------------------------
# spin <- Random (1,3)
# if{
#     spin = 1
#     display <- green
# } 
# else{
#     if{
#         spin=2
#         display <- blue
#     }
#     else{
#         display <- color khac
#     }
# }


# print("enter N > 0;")
# n = int (input())
# check = False

# for i in range(1, n+1):
#     if ( i**2 == n):
#         check = True
#         break

# if ( check == True):
#     print(n, "la so chinh phuong")
# else:
#     print(n, "kphai la so chinh phuong")


# def kiemtrasoHoanHao (n):
#     tong = 9
#     for i in range(1, n):
#         if(n % i) == 0:
#             tong += i
#     if tong == n:
#         return True
#     else:
#         return False


# n = int(input('enter N > 0;'))
# if kiemtrasoHoanHao(n):
#     print(n, "la so hoan hao")
# else:
#     print(n, "kphai so hoan hao")

# import numpy as np


# # Least-square function
# def f(x, A, b):
#     return np.linalg.norm(A @ x - b) ** 2

# # Gradient for least-square.
# def grad(x, A, b):
#     return 2 * (((A.T @ A) @ x) - A.T @ b)

# # Parameters.
# alpha = 0.3
# beta = 0.8
# t = 1
# count = 1

# A = np.array([[1, 2], [3, 4]])
# b = np.array([[5], [6]])
# x = np.random.normal(0, 1, (2))
# grad = grad(x, A, b)

# # Algorithm implementation.
# while (f((x - (t * grad)), A, b) > (f(x, A, b) - (alpha * t * np.linalg.norm(grad)**2))):
#        t *= beta
#        print('Iteration: {}'.format(count))
#        error = f(x, A, b) - (f((x - (t * grad)), A, b) + (alpha * t) * np.linalg.norm(grad)**2)
#        print('Error: {}'.format(error))
#        count += 1



#        from matplotlib.pyplot import figure, hold, plot, show, xlabel, ylabel, legend
# def f(x):
#         "The function we want to minimize"
#         return (x-3)**2
# def f_grad(x):
#         "gradient of function f"
#         return 2*(x-3)
# x = 0
# y = f(x)
# err = 1.0
# maxIter = 300
# curve = [y]
# it = 0
# step = 0.1
# #下面展示的是我之前用的方法，看上去貌似还挺合理的，但是很慢
# while err > 1e-4 and it < maxIter:
#     it += 1
#     gradient = f_grad(x)
#     new_x = x - gradient * step
#     new_y = f(new_x)
#     new_err = abs(new_y - y)
#     if new_y > y: #如果出现divergence的迹象，就减小step size
#         step *= 0.8
#     err, x, y = new_err, new_x, new_y
#     print 'err:', err, ', y:', y
#     curve.append(y)

# print 'iterations: ', it
# figure(); hold(True); plot(curve, 'r*-')
# xlabel('iterations'); ylabel('objective function value')