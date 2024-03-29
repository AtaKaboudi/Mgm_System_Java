import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

/**
 * Ce code d�montre l'utilisation de la m�thode setSelectedIndex() pour d�finir les �l�ments 
 * s�lectionn�s dans une JList par code.
 * L'exemple repose sur une recherche simple par un des trois champs d'une personne (id, nom, prenom).
 * Les exceptions ne sont pas trait�es, notament : NumberFormatException qui peut �tre provoquer par Interger.parseInt().
 */
public class ExempleRechercheJList extends JFrame implements ActionListener {
	
	JList liste;
	MonModel modele;
	
	JLabel lblNouveauId;
	JTextField txtNouveauId;
	JLabel lblNouveauNom;
	JTextField txtNouveauNom;
	JLabel lblNouveauPrenom;
	JTextField txtNouveauPrenom;
	JButton btnAjouter;
	JPanel pnlAjouter;
	
	ButtonGroup groupeRadio;
	JRadioButton optId;
	JRadioButton optNom;
	JRadioButton optPrenom;
	JLabel lblValeur;
	JTextField txtValeur;
	JButton btnChercher;
	JPanel pnlChercher;
	
	public ExempleRechercheJList(){
		
		construireObjetsInterface();
				
		modele = new MonModel();
		liste = new JList(modele);
		
		construireFenetre();
		
	}
	
	private void construireObjetsInterface(){
		construirePaneauAjouter();
		construirePaneauChercher();
	}
	
	private void construireFenetre(){
		setTitle("Exemple JList");
		setSize(1000, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(pnlAjouter, BorderLayout.CENTER);
		JScrollPane pnlListe = new JScrollPane(liste);
		pnlListe.setPreferredSize(new Dimension(200, 600));
		getContentPane().add(pnlListe, BorderLayout.WEST);
		getContentPane().add(pnlChercher, BorderLayout.EAST);
	}
	
	private void construirePaneauAjouter(){
		lblNouveauId = new JLabel("Id :");
		lblNouveauId.setBounds(20, 20, 150, 30);
		txtNouveauId = new JTextField();
		txtNouveauId.setBounds(190, 20, 150, 30);
		lblNouveauNom = new JLabel("Nom :");
		lblNouveauNom.setBounds(20, 70, 150, 30);
		txtNouveauNom = new JTextField();
		txtNouveauNom.setBounds(190, 70, 150, 30);
		lblNouveauPrenom = new JLabel("Pr�nom :");
		lblNouveauPrenom.setBounds(20, 120, 150, 30);
		txtNouveauPrenom = new JTextField();
		txtNouveauPrenom.setBounds(190, 120, 150, 30);
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(20, 170, 150, 30);
		btnAjouter.addActionListener(this);
		
		pnlAjouter = new JPanel();
		pnlAjouter.setLayout(null);
		pnlAjouter.add(lblNouveauId);
		pnlAjouter.add(txtNouveauId);
		pnlAjouter.add(lblNouveauNom);
		pnlAjouter.add(txtNouveauNom);
		pnlAjouter.add(lblNouveauPrenom);
		pnlAjouter.add(txtNouveauPrenom);
		pnlAjouter.add(btnAjouter);
	}
	
	private void construirePaneauChercher(){
		optId = new JRadioButton("Par Id");
		optId.setBounds(20, 20, 120, 30);
		optNom = new JRadioButton("Par Nom");
		optNom.setBounds(140, 20, 120, 30);
		optPrenom = new JRadioButton("Par Pr�nom");
		optPrenom.setBounds(260, 20, 120, 30);
		groupeRadio = new ButtonGroup();
		groupeRadio.add(optId);
		groupeRadio.add(optNom);
		groupeRadio.add(optPrenom);
		optId.setSelected(true);
		lblValeur = new JLabel("A chercher : ");
		lblValeur.setBounds(20, 70, 150, 30);
		txtValeur = new JTextField();
		txtValeur.setBounds(170, 70, 150, 30);
		btnChercher = new JButton("Chercher");
		btnChercher.setBounds(20, 120, 150, 30);
		btnChercher.addActionListener(this);
		
		pnlChercher = new JPanel();
		pnlChercher.setLayout(null);
		pnlChercher.add(optId);
		pnlChercher.add(optNom);
		pnlChercher.add(optPrenom);
		pnlChercher.add(lblValeur);
		pnlChercher.add(txtValeur);
		pnlChercher.add(btnChercher);
		pnlChercher.setPreferredSize(new Dimension(400, 600));
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnAjouter){
			traiterAjouter();
		}else{
			traiterChercher();
		}
	}
	
	private void traiterAjouter(){
		Personne p = new Personne(Integer.parseInt(txtNouveauId.getText()), txtNouveauNom.getText(), txtNouveauPrenom.getText());
		modele.addElement(p);
	}
	
	private void traiterChercher(){
		boolean etat = false;
		if(optId.isSelected()){
			etat = trouverId(Integer.parseInt(txtValeur.getText()));
		}else if(optNom.isSelected()){
			etat = trouverNom(txtValeur.getText());
		}else{
			etat = trouverPrenom(txtValeur.getText());
		}	
		
		if(!etat){
			JOptionPane.showMessageDialog(this, "Element non trouv�");
		}
	}
	
	public boolean trouverId(int id){
		boolean etat = false;
		int index = 0;
		while(index < modele.getDonnees().size() && !etat){
			if(modele.getDonnees().get(index).getId() == id){
				etat = true;
				liste.setSelectedIndex(index);
			}else{
				index++;
			}
		}
		return etat;
	}
	
	public boolean trouverNom(String nom){
		boolean etat = false;
		int index = 0;
		while(index < modele.getDonnees().size() && !etat){
			if(modele.getDonnees().get(index).getNom().equals(nom)){
				etat = true;
				liste.setSelectedIndex(index);
			}else{
				index++;
			}
		}
		return etat;
	}
	
	public boolean trouverPrenom(String prenom){
		boolean etat = false;
		int index = 0;
		while(index < modele.getDonnees().size() && !etat){
			if(modele.getDonnees().get(index).getPrenom().equals(prenom)){
				etat = true;
				liste.setSelectedIndex(index);
			}else{
				index++;
			}
		}
		return etat;
	}
	
	public static void main (String args[]) {
		
		(new ExempleRechercheJList()).setVisible(true);
		
	}
}

/*
 * Exemple d'une entit� de donn�es.
 */
class Personne {
	int id;
	String nom;
	String prenom;
	
	public Personne(int id, String nom, String prenom){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public int getId(){
		return id;
	}
	
	public String getNom(){
		return nom;
	}
	
	public String getPrenom(){
		return prenom;
	}
	
	@Override
	public String toString(){
		return "(" + id + ") " + nom + " " + prenom;
	}
}

/*
 * Mon mod�le pour la liste
 */ 
class MonModel extends AbstractListModel<Personne> {
	java.util.List<Personne> donnees;
	
	public MonModel(){
		donnees = new ArrayList<>();
	}
	
	public java.util.List<Personne> getDonnees(){
		return donnees;
	}
	
	public void addElement(Personne e){
		donnees.add(e);
		fireContentsChanged(e, getSize() - 1, getSize() - 1);
	}
	
	@Override
	public Personne getElementAt(int index){
		return donnees.get(index);
	}
	
	@Override
	public int getSize(){
		return donnees.size();
	}
}

