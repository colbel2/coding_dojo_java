reverse(nodeA=this.head,nodeB=null){
    if(nodeA==null){
        return;
    }
    if(nodeA.next==null){
        this.head=nodeA;
        nodeA.next=nodeB;
        return;
    }
    this.reverse(nodeA.next,nodeA);

    nodeA.next=nodeB;
    return;       
}



reverse() {
    if(this.length <= 1){
        return this;
    }

    let prevNode = this.head;
    let runner = this.head.next;
    while(runner != null){
        let nextNode = runner.next;
        runner.next = prevNode;
        prevNode = runner;
        runner = nextNode;
    }
    this.head.next = null;
    this.head = prevNode;
    return this;
}


reverse(){
    // next, current variables

    let runner = this.head;
    let nextNode = runner.next;
    let previousNode = null;

    while(runner.next != null){
        runner.next = previousNode;
        previousNode= runner;
        runner = nextNode;
        nextNode = nextNode.next;

    }
    runner.next = previousNode;
    this.head = runner;

}


reverse(temp=null){
    if(this.head.next != null){
        let runner = this.head;
        this.head = this.head.next;
        runner.next = temp;
        return this.reverse(runner);
    }
    this.head.next = temp;
    return;
}