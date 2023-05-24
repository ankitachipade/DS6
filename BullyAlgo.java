import java.util.Scanner;
class Process{
public int pid;
public String status;
public Process(int pid){
this.pid = pid;
this.status = "active";
}
}
public class BullyAlgo {
Scanner sc;
Process[] Process;
int num;
public BullyAlgo()
{
sc= new Scanner(System.in);
}
public void Round(){
System.out.println("Enter total number of Process of Process");
num = sc.nextInt();

Process = new Process[num];

for(int j = 0; j< num; j++){
Process[j]= new Process(j);
}
}
public void performElection(){
try {
Thread.sleep(100);
} catch (InterruptedException ae) {
ae.printStackTrace();
}
System.out.println("Process having pid "+Process[getMaxValue()].pid+" fails");
Process[getMaxValue()].status = "Inactive";
int currentpid = 0;
boolean oversts = true;
while(oversts){

boolean high = false;
for(int i = currentpid + 1; i< num; i++){
if(Process[i].status == "active"){
System.out.println("Process "+currentpid+" Passes Election("+currentpid+")message to process" +i);
high = true;
}
}
if(high){

for(int i = currentpid + 1; i< num; i++){

if(Process[i].status == "active"){
System.out.println("Process "+i+"Passes Ok("+i+") message to process" +currentpid);
}
}
currentpid++;
}
else{
int cod = Process[getMaxValue()].pid;
System.out.println("Finally Process "+cod+" Becomes codinator");
for(int i = cod - 1; i>= 0; i--){
if(Process[i].status == "active"){
System.out.println("Process "+cod+"Passes codinator("+cod+") message to process " +i);
}

}
System. out.println("End of Election");
oversts = false;
break;
}
}
}
public int getMaxValue(){
int Maxpid = -99;
int Maxpidin = 0;
for(int i = 0; i<Process.length; i++){
if(Process[i].status == "active" &&Process[i].pid >Maxpid){
Maxpid = Process[i].pid;
Maxpidin = i;
}
}
return Maxpidin;
}
public static void main(String[] args) {
BullyAlgo bully = new BullyAlgo();

bully.Round();
bully.performElection();
}
}
