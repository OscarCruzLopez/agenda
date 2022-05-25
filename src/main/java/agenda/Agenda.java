
package agenda;

//import exceptions.ContactoInexistenteException;
import exceptions.ContactoRepetidoException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author loned
 */
public class Agenda {

    private HashMap<String, Contacto> contactos = new HashMap();
    private static int n = 0;
    private static int count = 0;

    Agenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 /**
  * Añade un contacto a la agenda
  * @param contacto contacto que tenemos que añadir
  * @return objeto contacto añadido o genera una excepcion si ya existia
  * @throws ContactoRepetidoException Excepcion, ver paquete exception
  */
    public Contacto addContacto(Contacto contacto) throws ContactoRepetidoException {
        if (contactos.containsKey(contacto.getEmail())) {
            //
            throw new ContactoRepetidoException("Ya existe un contacto con email: " + contacto.getEmail());
        }
        n++;
        contacto.setN(n);
        contactos.put(contacto.getEmail(), contacto);
        count++;
        return contacto;
    }
/**
 * correo electronico que queremos eliminar
 * @param email
 * @return 
 */
    public Contacto eliminarContacto(String email) { 
        Contacto contacto = buscarContacto(email);
        if (contacto != null) {
        contactos.remove(email);
        count--;
        }
        return contacto;
    }
/**
 * busca los contactos de la agenda
 * @param email
 * @return 
 */
    public Contacto buscarContacto(String email) { 
        Contacto contacto = null;
        if (!contactos.containsKey(email)) {

            return null;
        }
        else{
        return contactos.get(email);
        }
    }
/**
 * coge los contactos de la agenda
 * @return 
 */
    public ArrayList<Contacto> getContactos() {
        ArrayList<Contacto> contactosList = new ArrayList<>();
        contactosList.addAll(contactos.values());
        return contactosList;
    }
    public static void ListaAgenda(Agenda a){
    
        ArrayList<Contacto> Listado = new ArrayList<>();
        Listado = a.getContactos();
        System.out.print("AGENDA: ");
        System.out.print(a.getnombreAgenda(a));
        System.out.println("\t\tNum.Contactos:"+Listado.size());
        System.out.format("%-24s%-15s%-15s\n", "eMail","Teléfono","Nombre");
        System.out.println("-----------------------------------------------------");
        for (Contacto c : Listado){
            System.out.format("%-24s%-15s%-15s\n",c.getEmail(),c.getTelefono(),c.getNombre());
        }
        System.out.println("-----------------------------------------------------");
    }
    private static String nombreAgenda="";

    public String getnombreAgenda(Agenda a){
            return this.nombreAgenda;
    }
    public void setnombreAgenda(String name){
            this.nombreAgenda=name;
    }

    public Agenda(String name){
    
        if (name != ""){
            this.nombreAgenda = name;
        }
        else this.nombreAgenda ="Untitled";
    }
    
    

}
