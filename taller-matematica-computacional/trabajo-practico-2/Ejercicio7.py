'''
7. Escribir un programa en Python que solicite por consola los nombres de pila de alumnos
de nivel primario de una escuela, finalizando al ingresar ”X”. Luego, solicitar que ingrese
los nombres de pila de los alumnos de nivel secundario, finalizando tambi ́en con ”X”.
Luego, incorporar funcionalidades que permitan:
a) Informar los nombres de todos los alumnos de nivel primario y de nivel secundario,
sin repeticiones.
b) Informar que nombres se repiten entre los alumnos de nivel primario y secundario.
c) Informar que nombres de nivel primario no se repiten en los de nivel secundario.
d) Informar que nombre de nivel secundario no se repiten en los de nivel primario.
'''

def ingresar_alumnos(nivel: str) -> set:
    alumnos = set()
    print(f"Ingrese los nombres de los alumnos de {nivel} (o 'X' para finalizar):")
    while True:
        nombre = input()
        if nombre.upper() == 'X':
            break
        
        if nombre.strip():
            alumnos.add(nombre.strip())
    return alumnos

alumnos_primario = ingresar_alumnos("primaria")
alumnos_secundario = ingresar_alumnos("secundaria")

print(f"\nNombres de todos los alumnos de nivel primario: {alumnos_primario}")
print(f"Nombres de todos los alumnos de nivel secundario: {alumnos_secundario}\n")

print(f"a) Alumnos totales (sin repeticiones): {alumnos_primario.union(alumnos_secundario)}")

print(f"b) Alumnos que se repiten en ambos niveles: {alumnos_primario.intersection(alumnos_secundario)}")

print(f"c) Alumnos de primaria que no están en secundaria: {alumnos_primario.difference(alumnos_secundario)}")

print(f"d) Alumnos de secundaria que no están en primaria: {alumnos_secundario.difference(alumnos_primario)}")