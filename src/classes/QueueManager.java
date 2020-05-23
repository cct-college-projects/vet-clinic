package classes;

import conf.SingletonLoadAnimals;
import conf.SingletonLoadStaff;
import helpers.HelperStrings;
import models.Dog;
import utils.BinarySearch;

import java.util.*;

import static helpers.HelperStrings.nChar;
import static helpers.HelperStrings.nCharIntervals;
import static utils.ToScreen.showMessage;

public class QueueManager {
    private int maxQueueSize = 10;
    private int qtyQueue = 6;
    private Map<Integer, VetQueue> queuesHolder = new HashMap();
    private ArrayList<Employee> vets;
    private ArrayList<Animals> animals;
    private Random rd = new Random();

    private static QueueManager instance = null;

    public QueueManager(){
        vets = SingletonLoadStaff.getInstance().getVetList();
        animals = SingletonLoadAnimals.getInstance().getAllAnimals();
        createQueues();
        fillQueues();
    }

    public static QueueManager getInstance() {

        if (instance == null) {

            instance = new QueueManager();
        }
        return instance;
    }

    private void createQueues(){
        if(vets.size() <= 0){
            System.out.println("There are no Vets working. Queues not created.");
        } else {
            for (int i = 0; i < qtyQueue; i++) {
                queuesHolder.put(vets.get(i).getEmp_id(), new VetQueue(maxQueueSize));
            }
        }
    }

    private void fillQueues(){
        boolean run;
        for (int i = 0; i < maxQueueSize; i++) {
            for (Integer id : queuesHolder.keySet()){
                run = true;
                while (run){
                    Animals animal = animals.get(rd.nextInt(1000));
                    if(!queueHas(animal)){
                        queuesHolder.get(id).enqueue(animal);
                        run = false;
                    }
                }
            }
        }
    }

    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    public Map<Integer, VetQueue> getQueuesHolder() {
        return queuesHolder;
    }

    public ArrayList<Employee> getVets() {
        return vets;
    }

    private boolean queueHas(Animals animal){
        for (Integer id : getQueuesHolder().keySet()){
            if(getQueuesHolder().get(id).has(animal)){
                return true;
            };
        }
        return false;
    }

    public void listAnimalsAssignedToVets(){
        for (Integer id : getQueuesHolder().keySet()){
            Employee vet = BinarySearch.vetyById(vets, id);
            showMessage(nChar('-', 100));
            showMessage("Dr. "+vet.getFullName()+" - "+vet.getClass().getSimpleName()+" - ID: "+vet.getEmp_id()+" - Qty Animals: "+getQueuesHolder().get(id).size());
            showMessage(nChar('-', 100));
            for (Animals animal:getQueuesHolder().get(id).asArrayList()) {
                showMessage("\t"+animal.getFullInformation());
            }
        }
        showMessage(nChar('-', 100));
    }

    public void listAnimalsOrderInTheQueue(){
        String[] arrayVets = new String[qtyQueue];
        int indexVet = 0;
        for (Integer id : getQueuesHolder().keySet()){
            //System.out.println("Dr. "+BinarySearch.vetyById(vets, id).getName()+"\t"+getQueuesHolder().get(id).toString());
            arrayVets[indexVet] = BinarySearch.vetyById(this.vets, id).getName();
            indexVet++;
        }

        showMessage(nChar('-', 103));
        showMessage("VERTICAL VIEW");
        showMessage(nChar('-', 103));
        int[] colsHeader = {7, 23, 39, 55, 71, 87, 103};

        ArrayList<Animals[]> linhas = new ArrayList<>();
        Animals[] colunas = new Animals[6];
        for (int linha = 0; linha < 10; linha++) {
            int ncol = 0;
            for (Integer id : getQueuesHolder().keySet()){
                colunas[ncol] = getQueuesHolder().get(id).asList().get(linha) == null ? new Dog(0,"xxxxx", 0, " ") : getQueuesHolder().get(id).asList().get(linha);
                linhas.add(colunas);
                ncol++;
            }
            String col1, col2, col3, col4, col5, col6;
            col1 = HelperStrings.addTabToString(linhas.get(linha)[0].getName());
            col2 = HelperStrings.addTabToString(linhas.get(linha)[1].getName());
            col3 = HelperStrings.addTabToString(linhas.get(linha)[2].getName());
            col4 = HelperStrings.addTabToString(linhas.get(linha)[3].getName());
            col5 = HelperStrings.addTabToString(linhas.get(linha)[4].getName());
            col6 = HelperStrings.addTabToString(linhas.get(linha)[5].getName());
            System.out.println("#"+(10-linha)+"\t\t"+col1+"\t\t"+col2+"\t\t"+col3+"\t\t"+col4+"\t\t"+col5+"\t\t"+col6);
        }

        showMessage(nCharIntervals('-', ' ', colsHeader));
        showMessage("POS\t\tQUEUE 1\t\t\tQUEUE 2\t\t\tQUEUE 3\t\t\tQUEUE 4\t\t\tQUEUE 5\t\t\tQUEUE 6");
        showMessage(nCharIntervals('-', ' ', colsHeader));
        showMessage("Dr.\t\t"+arrayVets[0]+"\t\t\t"+arrayVets[1]+"\t\t\t"+arrayVets[2]+"\t\t\t"+arrayVets[3]+"\t\t\t"+arrayVets[4]+"\t\t\t"+arrayVets[5]);
        showMessage(nChar('-', 103));
        showMessage("HORIZONTAL VIEW");
        showMessage(nChar('-', 103));
        for (Integer id : getQueuesHolder().keySet()){
            String name = HelperStrings.addTabToString(BinarySearch.vetyById(vets, id).getName());
            System.out.println("Dr. "+name +"\t"+getQueuesHolder().get(id).toString());

        }
    }

    public boolean isVeterinaryWorking(int idVet){
        for (Integer id : getQueuesHolder().keySet()){
            if(id == idVet){
                return true;
            }
        }
        return false;
    }

    /**
     * This Random().nextInt(int bound) generates a random integer from 0 (inclusive) to bound (exclusive).
     * For getRandomNumberInRange(1, 1000), this will generates a random integer between 1 (inclusive) and 1000 (inclusive).
     * @see <a href="https://mkyong.com/java/java-generate-random-integers-in-a-range/">Source</a>
     * @author mkyong
     * */
    private int randIntRange(int min, int max){
        return rd.nextInt((max - min) + 1) + min;
    }
}
