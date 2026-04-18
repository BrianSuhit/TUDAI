'''
3. Escribir un programa que permita incorporar elementos al conjunto A por consola hasta
que el usuario ingrese la letra x.
'''

A: set = {1, 2, 3, 4, 5}

print(f"ingrese un numero para incorporar al conjunto {A} o ingrese x para finalizar.")

while True:
    entrada = input()
    if entrada.lower() == 'x':
        break
    try:
        num_a_incorporar = int(entrada)
        A.add(num_a_incorporar)
    except ValueError:
        print("Entrada invalida. Por favor, ingrese un numero entero o 'x' para finalizar.")

print(f"Conjunto actualizado: {A}")