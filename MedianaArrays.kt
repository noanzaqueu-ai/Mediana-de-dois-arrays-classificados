class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // Garante que nums1 é o menor array (para otimizar a busca binária)
        if (nums1.size > nums2.size) {
            return findMedianSortedArrays(nums2, nums1)
        }

        val m = nums1.size
        val n = nums2.size
        var low = 0
        var high = m

        while (low <= high) {
            // partitionX: quantos elementos de nums1 ficam à esquerda
            val partitionX = (low + high) / 2
            // partitionY: quantos elementos de nums2 ficam à esquerda
            val partitionY = (m + n + 1) / 2 - partitionX

            // Valores das bordas (usando infinito para partições vazias)
            val maxLeftX = if (partitionX == 0) Int.MIN_VALUE else nums1[partitionX - 1]
            val minRightX = if (partitionX == m) Int.MAX_VALUE else nums1[partitionX]

            val maxLeftY = if (partitionY == 0) Int.MIN_VALUE else nums2[partitionY - 1]
            val minRightY = if (partitionY == n) Int.MAX_VALUE else nums2[partitionY]

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Partição correta encontrada
                return if ((m + n) % 2 == 0) {
                    (maxOf(maxLeftX, maxLeftY) + minOf(minRightX, minRightY)) / 2.0
                } else {
                    maxOf(maxLeftX, maxLeftY).toDouble()
                }
            } else if (maxLeftX > minRightY) {
                // Precisamos mover a partição de nums1 para a esquerda
                high = partitionX - 1
            } else {
                // Precisamos mover a partição de nums1 para a direita
                low = partitionX + 1
            }
        }

        throw IllegalArgumentException("Arrays de entrada não estão ordenados corretamente")
    }
}
