'''
1. Declarar una variable booleana en python y
asignarle un valor de verdad

'''
dato_booleano: bool = True


'''
2.  Escribir una función en Python que imprima por pantalla "Verdadero" si la entrada es un 
valor verdadero, o que en caso contrario no imprima nada. 

'''
print("Ingrese un valor sea verdadero o falso")
usuario_input = input().lower().strip()

if usuario_input == "verdadero":
    print("Verdadero")
    
    
'''
3. Escribir una función en Python que determine si un número dado es múltiplo de 2.

'''
numero: int = 5

if numero % 2 == 0:
    print("El numero es multiplo de 2")
else:
    print("El numero no es multiplo de 2")
    
    
'''
4. Escribir una nueva función que controle si un número dado es par o múltiplo de 3. 

'''
if numero % 2 == 0 or numero % 3 == 0:
    print("El numero es par o multiplo de 3")
else:
    print("El numero no es par ni multiplo de 3")
    
    
'''
5. Dada la siguiente función Python: 
a) Indique cuál será el valor que retorna la función para cada combinación de parámetros 
de entrada. 
b) Proponga una modificación para optimizar la función.
'''

# def func(p, q, r): 
#     if (p = q) and (r or not r):
#     else: 
#         return False 
#         return True
    
def fun_corregida(p, q):
    return print("valor: " + p == q)