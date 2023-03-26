abstract class Cola<TIPO> {
        var cola: ArrayList<TIPO> = ArrayList()

        fun emptyQueue(){
            this.cola.removeAll(cola)
        }

        fun addFirst(e: TIPO){
            if (!this.cola.isEmpty()){
                this.cola.add(0,e)
            }else{
                this.cola.add(e)
            }
        }

        open fun addLast(e: TIPO) {
          this.cola.add(e)
        }

        open fun isEmpty(): Boolean {
            var vacio: Boolean = this.cola.isEmpty()
            return vacio
        }

        fun peek(): TIPO? {
            var dato: TIPO? = null
            if (!this.cola.isEmpty()){
                dato = this.cola.get(this.cola.size-1)
            }
            return dato
        }

        fun removeFirst() {
            this.cola.removeFirst()
        }

        fun removeLast(){
            this.cola.removeLast()
        }

        fun pop():TIPO?{
            var dato: TIPO? = null
            if (!this.cola.isEmpty()){
                dato = this.cola.get(this.cola.size-1)
                this.cola.removeLast()
            }
            return dato
        }

    override fun toString(): String {
        var cad:String = ""
        for (i in this.cola.indices){
            cad = cad + this.cola.get(i).toString()
            cad = cad + "\n"
        }
        return cad
    }
}