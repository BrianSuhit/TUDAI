'''
3. Escribir una función en Python que determine si un número dado es múltiplo de 2.
'''

MULTIPLO: int = 2

numero: int = 5

if numero % MULTIPLO == 0:
    print(f"El numero {numero} es multiplo de {MULTIPLO}")
else:
    print("El numero {numero} no es multiplo de {MULTIPLO}")
    