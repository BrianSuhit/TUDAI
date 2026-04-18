'''
6. Escribir una funcion en Python que, dados dos conjuntos, determine si uno es subconjunto
del otro.
'''

A: set = {1, 2, 3, 4, 5}

B: set = {2, 4, 6, 8}

print(f"a) A ⊆ B: {A.issubset(B)}")
print(f"a) B ⊆ A: {B.issubset(A)}")