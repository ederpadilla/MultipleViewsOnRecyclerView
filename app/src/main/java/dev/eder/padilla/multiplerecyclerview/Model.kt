package dev.eder.padilla.multiplerecyclerview

class Model(var title: String, var type: Int) {
    companion object {

        val TYPE_ONE = 1

        val TYPE_TWO = 2
    }

    override fun toString(): String {
        return "Model(title='$title', type=$type)"
    }

}
