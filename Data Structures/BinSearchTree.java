public class BinSearchTree{

    public BinNode root;

    public BinNode findMinimum(){
        return findMin(root);
    }
    private BinNode findMin(BinNode nd){
        if(nd.left == null){
            return nd;
        }
        return findMin(nd.left);
    }
    
    public BinNode findMaximum(){
        return findMax(root);
    }
    private BinNode findMax(BinNode nd){
        if(nd.right == null){
            return nd;
        }
        return findMax(nd.right);
    }

    public BinNode findNode(int value){
        BinNode n = root;       //Wurzel

        while(n != null){       //Suche, solange bis gefunden oder keine Nachfolger mehr
            if(value == n.element){
                return n;       //Gefunden
            }
            else if(value < n.element)
            {
                n = n.left;     //links weiter
            }
            else
            {
                n = n.right;    //rechts weitersuchen
            }
        
        }
        return null;        //Nicht gefunden
    }

    public boolean insertNode(BinNode bn){
        BinNode child = root;
        BinNode parent = null;

        while(child != null){
            parent = child;
            if(bn.element == child.element){    //duplikat
                return false;
            }
            else if(bn.element < child.element)
            {   //links weiter
                child = child.left;
            }
            else
            {
                child = child.right;        //rechts weiter
            }
        }

        if(parent==null){
            root = bn;      //Baum leer? ->root setzen
        }
        else if(bn.element < parent.element){
            parent.left = bn;       //test ob links einfügen
        }
        else
        {
            parent.right = bn;      //test ob rechts einfügen
        }
        return true;
    }

    public void deleteMin(){
        root = deleteMin(root);
    }
    
    private BinNode deleteMin(BinNode nd){
        if(nd.left == null) return nd.right;
        
        nd.left = deleteMin (nd.left);
        return nd;
    }

    public void  deleteMax(){
        root = deleteMax(root);
    }

    private BinNode deleteMax(BinNode nd){
        if(nd.right == null) return nd.left;

        nd.right = deleteMax (nd.right);
        return nd;
    }

    public void delete(int element){
        root = delete(root,element);    //root wird gleich 
    }

    private BinNode delete(BinNode nd, int nummer){     //nd ist hier root durch die public Methode "delete"
        if(nd == null) return null;  //abbruchbediengung für Rekursion

        if(nummer < nd.element) nd.left = delete(nd.left, nummer);  //test ob links löschen

        else if(nummer > nd.element) nd.right = delete(nd.right, nummer);   //test ob rechts löschen
        
        else //zu löschender Knoten gefunden
        {      
            if(nd.right == null) return nd.left;
            if(nd.right == null) return nd.right;
            
            //ab hier wird der Fall behandelt,
            //dass der zu löschende Knoten 2 Nachfolger hat

            BinNode tmp = nd;   //zu löschender Knoten wird gespeichert

            nd = findMin(tmp.right);    //Min im rechten Teilbaum finden und speichern

            nd.right = deleteMin(tmp.right);    //Min im rechten Teilbaum löschen und right aktualisieren

            nd.left = tmp.left;     //left des hochgezogenen Knotens aktualisieren
        }
        return nd;
    }

    public int countNodes(BinNode nd){
        int counter = 0;

        if(nd.left != null) {
            //counter++;
            counter += countNodes(nd.left);
        }

        if(nd.right != null){
            //counter++;
            counter += countNodes(nd.right);
        }

        /*if(nd == root){
            counter++;
        }*/

        return counter+1 ;
    }

    public BinNode insertRecursive(BinNode root, BinNode neu){
        BinNode current = root;

        if(neu.element>current.element){
            if(current.right == null){
                current.right = neu;
                return neu;
            }
            else{
                current = current.right;
                insertRecursive(current, neu);
            }
        }

        if(neu.element<current.element){
            if(current.left == null){
                current.left = neu;
                return neu;
            }
            else{
                current = current.left;
                insertRecursive(current, neu);
            }
        }
        return neu;

    }

}