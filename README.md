# Median of Two Sorted Arrays (Kotlin)

Solução em Kotlin para o problema **LeetCode #4 - Median of Two Sorted Arrays**, 
utilizando busca binária para encontrar a mediana de dois arrays ordenados 
em tempo `O(log(min(m,n)))`, sem a necessidade de mesclar os arrays.

## 🧩 Problema
Dados dois arrays ordenados `nums1` e `nums2`, retornar a mediana dos dois arrays combinados.

## ⚙️ Abordagem
- Busca binária no menor dos dois arrays.
- Particiona ambos os arrays de forma que os elementos à esquerda sejam 
  sempre menores ou iguais aos elementos à direita.
- Trata separadamente os casos de soma par e ímpar de elementos.

## 📊 Complexidade
- **Tempo:** O(log(min(m, n)))
- **Espaço:** O(1)

## ▶️ Como executar
```bash
kotlinc Solution.kt -include-runtime -d solution.jar
java -jar solution.jar
```
