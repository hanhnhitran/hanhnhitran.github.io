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


print("enter N > 0;")
n = int (input())
check = False

for i in range(1, n+1):
    if ( i**2 == n):
        check = True
        break

if ( check == True):
    print(n, "la so chinh phuong")
else:
    print(n, "kphai la so chinh phuong")


def kiemtrasoHoanHao (n):
    tong = 9
    for i in range(1, n):
        if(n % i) == 0:
            tong += i
    if tong == n:
        return True
    else:
        return False


n = int(input('enter N > 0;'))
if kiemtrasoHoanHao(n):
    print(n, "la so hoan hao")
else:
    print(n, "kphai so hoan hao")

import numpy as np




