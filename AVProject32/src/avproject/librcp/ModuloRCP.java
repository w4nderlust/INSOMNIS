package avproject.librcp;

import COM.hugin.HAPI.*;

/*
 * Classe singleton
 */
public class ModuloRCP {

    private ModuloRCP() {
        try {
            livello_difficolta_iniziale = new Domain("livello_difficolta_iniziale.hkb");
            visualizzazione_iniziale = new Domain("visualizzazione_iniziale.hkb");
            ogni_livello = new Domain("ogni_livello.hkb");
        } catch (ExceptionHugin EH) {
            System.out.println(EH.getMessage());
        }
    }

    public static ModuloRCP getInstance() {
        if (moduloRcp == null)
            moduloRcp = new ModuloRCP();
        return moduloRcp;
    }

    public void setEvidence(String RCPName, String NodeName, int state){
        Domain dominio = null;
        DiscreteChanceNode nodo = null;

        if (RCPName.equalsIgnoreCase("livello_difficolta_iniziale"))
            dominio = livello_difficolta_iniziale;
        else if (RCPName.equalsIgnoreCase("ogni_livello"))
            dominio = ogni_livello;
        else if (RCPName.equalsIgnoreCase("visualizzazione_iniziale"))
            dominio = visualizzazione_iniziale;

        try {
            nodo = (DiscreteChanceNode) dominio.getNodeByName(NodeName);
            nodo.selectState(state);

            if (dominio.isCompiled())
                dominio.propagate(dominio.H_EQUILIBRIUM_SUM, dominio.H_EVIDENCE_MODE_NORMAL);
            else
                dominio.compile();

        } catch (ExceptionHugin EH) {
            System.out.println(EH.getMessage());
        }
    }

    public double getBelief(String RCPName, String NodeName, int state){
        Domain dominio = null;
        DiscreteChanceNode nodo = null;
        double belief = -1;
        

        if (RCPName.equalsIgnoreCase("livello_difficolta_iniziale"))
            dominio = livello_difficolta_iniziale;
        else if (RCPName.equalsIgnoreCase("ogni_livello"))
            dominio = ogni_livello;
        else if (RCPName.equalsIgnoreCase("visualizzazione_iniziale"))
            dominio = visualizzazione_iniziale;

        try {
            nodo = (DiscreteChanceNode) dominio.getNodeByName(NodeName);
            belief = nodo.getBelief(state);
        } catch (ExceptionHugin EH) {
            System.out.println(EH.getMessage());
        }

        return belief;
    }

    public void printRCP(String RCPName) {
        Domain dominio = null;
        DiscreteChanceNode nodo;
        NodeList list;

        if (RCPName.equalsIgnoreCase("livello_difficolta_iniziale")) {
            dominio = livello_difficolta_iniziale;
        } else if (RCPName.equalsIgnoreCase("ogni_livello")) {
            dominio = ogni_livello;
        } else if (RCPName.equalsIgnoreCase("visualizzazione_iniziale")) {
            dominio = visualizzazione_iniziale;
        }

        try {
            System.out.println("RCP: " + dominio.getFileName());
            list = dominio.getNodes();
            for (Object n : list) {
                nodo = (DiscreteChanceNode) n;
                System.out.println("Nodo: " + nodo.getName());
                for (int i = 0; i < nodo.getNumberOfStates(); i++) {
                    System.out.println(nodo.getStateLabel(i) + ": " + nodo.getBelief(i));
                }
            }
            System.out.println("");
            System.out.println("");
        } catch (ExceptionHugin EH) {
            System.out.println(EH.getMessage());
        }
    }
    
    private static ModuloRCP moduloRcp = null;
    private Domain livello_difficolta_iniziale;
    private Domain visualizzazione_iniziale;
    private Domain ogni_livello;
}

