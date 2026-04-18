'''
5. A partir de los conjuntos A y B anteriores, calcular en Python:
a) A ∪ B
b) A ∩ B
c) A − B
d) B − A
'''

A: set = {1, 2, 3, 4, 5}

B: set = {2, 4, 6, 8}

print(f"Conjunto A: {A}")
print(f"Conjunto B: {B}")

print(f"a) A U B: {A.union(B)}")                # {A | B}
print(f"b) A n B: {A.intersection(B)}")         # {A & B}
print(f"c) A - B: {A.difference(B)}")           # {A - B}
print(f"d) B - A: {B.difference(A)}")           # {B - A}
print(f"e) A ^ B: {A.symmetric_difference(B)}") # {A ^ B}