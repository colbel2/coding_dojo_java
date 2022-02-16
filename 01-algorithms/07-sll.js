class Node {
    constructor(valueInput){
        this.value = valueInput;
        this.next = null
    }
}


class SLL {
    constructor(){
        this.head = null;
    }

    addToBack(valueInput){
        //create a node object with a given value to add to the back of the list eventually 
        let newNode = new Node(valueInput)
        //if the singly linked list is empty (this mean that its head === null), then set the head of the singly linked list to be this new node
        if(this.head == null){
            this.head = newNode;
        }
        //otherwise (else) go to the end of the list and insert the node to the end
        else{ //else means that the list is not empty
            console.log("this.head looks like this-->", this.head)
            let runner = this.head; //create runner variable to start at the beginning of the list (the head)
            
            //increment runner while runner.next != null (as long as the runner.next does not equal to null, that meanns runner is not at the last node)
            while(runner.next != null){ //in other words (while runner is not the last node)
                runner = runner.next //this moves runner to the next node
            }

            //by the time while loop is done, we will have runner pointing to the last node
            runner.next = newNode;

        }
    }

    display(){
        let result = "";

        //use runner to traverse the SLL
        let runner = this.head;
        while(runner != null){ //while runner is pointing at a node
            result += `${runner.value} -->`
            runner = runner.next //this is how you increment runner to go to the next node
        }

        console.log(result)
    }


    addtoFront(value){

    }

    removeFront(){

    }

    removeBack(){
        
    }



}

let sll1 = new SLL()

sll1.addToBack(3)
sll1.addToBack(12)
sll1.addToBack(15)
sll1.addToBack(9)

sll1.display()

console.log(sll1)
// let firstNode = new Node(3);
// let secondNode = new Node(9);
// firstNode.next = secondNode

// let thirdNode = new Node(12);

// secondNode.next = thirdNode;



class Node {
    constructor(value,) {
        this.value = value
        this.next = null
    }
}
class SinglyLinkedList {
    constructor() {
        this.head = null
    }
    pushNode(value) {
        let pushedNode = new Node(value)
        if (this.head == null) {
            this.head = pushedNode
        }
        else {
            let runner = this.head
            while (runner.next != null) {
                runner = runner.next
            }
            runner.next = pushedNode
        }
    }
    unshiftNode(value){
        let unshiftedNode = new Node(value)
        if(this.head == null){
            this.head = unshiftedNode
        }
        else{
            unshiftedNode.next = this.head
            this.head = unshiftedNode
        }
    }
    shiftNode(){
        let removedNode = this.head
        this.head = removedNode.next
        removedNode.next = null
        return removedNode
    }
    popNode(){
        let runner = this.head
        while (runner.next.next != null){
            runner = runner.next
        }
        let tail = runner.next
        runner.next = null
        return tail
    }
    displayList(){
        let singlyLinkedList = ""
        let runner = this.head
        while (runner != null) {
            singlyLinkedList += runner.value + "-"
            runner = runner.next
        }
        console.log(singlyLinkedList)
    }
}






class Node {
    constructor(valueInput){
        this.value = valueInput;
        this.next = null
    }
}


class SLL {
    constructor(){
        this.head = null;
    }

    addToBack(valueInput){
        //create a node object with a given value to add to the back of the list eventually 
        let newNode = new Node(valueInput)
        //if the singly linked list is empty (this mean that its head === null), then set the head of the singly linked list to be this new node
        if(this.head == null){
            this.head = newNode;
        }
        //otherwise (else) go to the end of the list and insert the node to the end
        else{ //else means that the list is not empty
            console.log("this.head looks like this-->", this.head)
            let runner = this.head; //create runner variable to start at the beginning of the list (the head)
            
            //increment runner while runner.next != null (as long as the runner.next does not equal to null, that meanns runner is not at the last node)
            while(runner.next != null){ //in other words (while runner is not the last node)
                runner = runner.next //this moves runner to the next node
            }

            //by the time while loop is done, we will have runner pointing to the last node
            runner.next = newNode;

        }
    }

    display(){
        let result = "";

        //use runner to traverse the SLL
        let runner = this.head;
        while(runner != null){ //while runner is pointing at a node
            result += `${runner.value} -->`
            runner = runner.next //this is how you increment runner to go to the next node
        }

        console.log(result)
    }


    addtoFront(value){
        let newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
    }

    removeFront(){
        this.head = this.head.next;
    }

    removeBack(){
        if (this.head.next === null) { //if we only have 1 node in our list
            this.head = null;
            return;
        }
        let runner = this.head;
        while (true) {
            runner = runner.next;
            if (runner.next.next===null) {
                runner.next=null;
                return;
            }
        }
    }



}

let sll1 = new SLL()

sll1.addToBack(3)
sll1.addToBack(12)
sll1.addToBack(15)
sll1.addToBack(9)


sll1.addtoFront(1)
sll1.removeFront();
sll1.removeBack();
sll1.display()
console.log(sll1)







