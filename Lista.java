public class Lista {
    public Lista() {
        this.first = new Node(null, null);
    }
    Node first;
    Node last;
    int length = 0;
    public int size() {
        return this.length;
    }
    
    // Inserir no Início
    public void addToStart(Object obj) throws Exception {
        insert(obj, 0);
    }

    public Object get(int i) {
        int count = 0;
        Node current = first.next();        
        while (count <= i) {
            current = current.next();
            i++;
        }
        return current;
    }


    //Inserir no Fim
    public void addToEnd(Object obj) throws Exception {
        Node objNode = new Node(obj);
        if (this.length == 0) {
            this.first.pointTo(objNode);
            this.length++;
            this.last = objNode;
            System.out.println("entrei");
            return;
        }
        this.last.pointTo(objNode);
        this.last = objNode;
        this.length++;
    }

    //Inserir por Posição
    public void insert(Object obj, int index) throws IndexOutOfRange {
        Node current = this.first;
        int count = 0;
        Node objNode = new Node(obj);
        while (current.hasNext()) {
            if(count++ == index) {
                Node temp = current.next();
                current.pointTo(objNode);
                objNode.pointTo(temp);
                this.length++;
                return;
            }
            current = current.next();
        }
        if (count == index) {
            current.pointTo(objNode);
            this.last = objNode;
            this.length++;
            return;
        }
        throw new IndexOutOfRange();
    }

    // Remover do Início;
    public void removeAtStart() throws IndexOutOfRange {
        if (this.length >= 1) {
            this.first.pointTo(first.next().next());
            this.length--;
            return;
        }
        throw new IndexOutOfRange();
    }

    // Remover do Final
    public void removeAtEnd() throws IndexOutOfRange {
        if (this.length >= 1) {
            this.removeAtIndex(length - 1);
            return;
        }
        throw new IndexOutOfRange();
    }

    // Remover por Valor
    public void removeByValue(Object target) {
        Node current = this.first;
        while (current.hasNext()) {
            if (current.next() == target) {
                current.pointTo(current.next().next());
                this.length--;
                return;
            }
        }
    }

    // Remover por Posição
    public void removeAtIndex(int index) throws IndexOutOfRange {
        Node current = this.first;
        int count = 0;
        if (index == 0) {
            this.removeAtStart();
            return;
        }
        while ( count < index && current.hasNext()) {
            if(++count == index) {
                current.pointTo(current.next().next());
                this.length--;
                if (index + 1 == this.length) {
                    this.last = current;
                }
                return;
            }
            current = current.next();
        }
    }



    public String toString() {
        String response = "["; 
        Node current = this.first;
        boolean firstLoop = true;
        while (current.hasNext()) {
            current = current.next();
            if (current.getValue() != null) {
                if (firstLoop) {

                } else {
                    response += (" "+current.getValue()+",");
                }
            }
        }
        if (response.endsWith(",")) {
            response = response.substring(0, response.length()-1);
        }
        response =  response.strip();
        response += "]";
        return response;
    }

    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();
        lista.addToEnd(13);
        System.out.println(lista);
        System.out.println(lista.size());
        lista.get(0);
        lista.get(1);
    }

}
