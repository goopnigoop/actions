import java.util.*

object Main {
    private val arr = intArrayOf(1, 5, 7, 3, 2, 6, 8, 3, 6, 34, 654, 234, 77)

    @JvmStatic
    fun main(args: Array<String>) {
        println("Not Sorted: " + arr.contentToString())
        var ints = sortWithBubbles(arr)
        println("Sorted with bubbles " + ints.contentToString() + " " + isSorted(ints))
        println("Not Sorted: " + arr.contentToString())
        ints = sortSimple(arr)
        println("Sorted simple " + ints.contentToString() + " " + isSorted(ints))
        println("Not Sorted: " + arr.contentToString())
        ints = sortInsertion(arr)
        println("Sorted with insertion " + ints.contentToString() + " " + isSorted(ints))
        println("Not Sorted: " + arr.contentToString())
        ints = sortQuick(arr)
        println("Sorted with quick sort " + ints.contentToString() + " " + isSorted(ints))
    }

    private fun sortQuick(arr: IntArray): IntArray {
        val ints = arr.copyOf(arr.size)
        val start = 0
        val end = arr.size - 1
        qs(ints, start, end)
        return ints
    }

    private fun qs(ints: IntArray, start: Int, end: Int) {
        var l = start
        var h = end
        val mid = l + (h - l) / 2
        val m = ints[mid]
        while (l <= h) {
            while (ints[l] < m) {
                l++
            }
            while (ints[h] > m) {
                h--
            }
            if (l <= h) {
                swap(ints, l, h)
                l++
                h--
            }
        }
        if (start < h) {
            qs(ints, start, h)
        }
        if (l < end) {
            qs(ints, l, end)
        }
    }

    private fun sortInsertion(arr: IntArray): IntArray {
        val ints = arr.copyOf(arr.size)
        for (i in 1 until ints.size) {
            for (j in i downTo 1) {
                if (ints[j] < ints[j - 1]) {
                    swap(ints, j, j - 1)
                }
            }
        }
        return ints
    }

    private fun sortSimple(arr: IntArray): IntArray {
        val ints = arr.copyOf(arr.size)
        for (i in ints.indices) {
            for (j in i + 1 until ints.size) {
                if (ints[i] > ints[j]) {
                    swap(ints, i, j)
                }
            }
        }
        return ints
    }

    private fun sortWithBubbles(arr: IntArray): IntArray {
        val ints = arr.copyOf(arr.size)
        for (i in 0 until ints.size - 1) {
            var swapped = false
            for (j in 0 until ints.size - 1) {
                if (ints[j] > ints[j + 1]) {
                    swap(ints, j, j + 1)
                    swapped = true
                }
            }
            if (!swapped) {
                break
            }
        }
        return ints
    }

    private fun isSorted(arr: IntArray): Boolean {
        if (arr.size < 2) {
            return true
        }
        for (i in 0 until arr.size - 1) {
            if (arr[i] > arr[i + 1]) {
                return false
            }
        }
        return true
    }

    private fun swap(ints: IntArray, j: Int, i: Int) {
        val res = ints[j] * ints[i]
        ints[j] = res / ints[j]
        ints[i] = res / ints[i]
    }
}