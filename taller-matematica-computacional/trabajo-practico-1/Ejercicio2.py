'''
2.  Escribir una función en Python que imprima por pantalla "Verdadero" si la entrada es un 
valor verdadero, o que en caso contrario no imprima nada. 
'''

print("Ingrese un valor sea verdadero o falso")
usuario_input = input().lower().strip()

if usuario_input == "verdadero":
    print("Verdadero")