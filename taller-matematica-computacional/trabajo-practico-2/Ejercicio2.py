'''
2. Escribir un programa que, dado un n ́umero por consola, verifique si es un elemento del
conjunto A.
'''

A: set = {1, 2, 3, 4, 5}

print(f"Ingrese un numero para verificar si pertenece al conjunto A: {A}")
num_ingresado = int(input())

if(num_ingresado in A):
    print(f"El numero ingresado {num_ingresado} si pertenece al conjunto {A}")
else:
    print(f"El numero ingresado {num_ingresado} no pertenece al conjunto {A}")