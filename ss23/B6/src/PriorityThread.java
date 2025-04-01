class PriorityThread extends Thread{
    public PriorityThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println(getName() + " is running with priority " + getPriority());
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
