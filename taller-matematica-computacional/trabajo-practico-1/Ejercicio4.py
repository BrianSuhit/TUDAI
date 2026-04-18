'''
4. Escribir una nueva función que controle si un número dado es par o múltiplo de 3. 
'''

MULTIPLO_2: int = 2

MULTIPLO_3: int = 3

numero: int = 5

if numero % MULTIPLO_2 == 0 or numero % MULTIPLO_3 == 0:
    print(f"El {numero} es par o multiplo de {MULTIPLO_3}")
else:
    print(f"El numero {numero} no es par ni multiplo de {MULTIPLO_3}")
    