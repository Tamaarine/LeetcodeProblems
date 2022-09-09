from typing import *

def rotate(matrix: List[List[int]]) -> None:
    newMatrix = [[0 for i in range(len(matrix[0]))] for i in range(len(matrix))]
    print(newMatrix)
    for i, row in enumerate(matrix):
        for col in range(len(row)):
            newMatrix[col][len(matrix) - i - 1] = row[col]
    for row in range(len(matrix)):
        for col in range(len(matrix)):
            matrix[row][col] = newMatrix[row][col]
    return newMatrix

matrix1 = [[1, 2, 3], 
            [2, 2, 2],
            [5, 5, 5]]
print(rotate(matrix1))
print(matrix1)