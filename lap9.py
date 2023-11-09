# from collections import deque

# def is_precede(op1, op2):
#     precedence = {'(': 0,
#                   '+': 1, '-': 1,
#                   '*': 2, '/': 2,
#                   '^': 3}
#     return precedence[op1] >= precedence[op2]  

# def infix_to_postfix(infix):

#     stack = deque()
#     postfix = []

#     for el in infix.split(' '):
#         try:           
#             float(el)
#             postfix.append(el)
#         except:       
#             if el in ['(', '^']:  
#                 stack.append(el)
#             elif el == ')':      
#                 while True:  
#                     operator = stack.pop()
#                     if operator == '(':
#                         break
#                     postfix.append(operator)
#             else:           
#                 while len(stack) > 0 and is_precede(stack[-1], el):
#                     postfix.append(stack.pop())
#                 stack.append(el)
    
#     while len(stack) > 0:
#         postfix.append(stack.pop())
        
#     return ' '.join(postfix)


# def infix_to_postfix_evaluate(infix):
#     postfix_str = infix_to_postfix(infix)
#     expr_value = eval_postfix(postfix_str)
#     return postfix_str, expr_value


# infix_to_postfix_evaluate("5 ^ 2 / ( 5 * 3 ) + 2")



    





