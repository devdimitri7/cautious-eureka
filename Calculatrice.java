package dimi.org;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculatrice extends JFrame {
	//Creation des panels des boutons et des variables
	private JPanel pan = new JPanel();
	private JButton bouton = new JButton("1");
	private JButton bouton2 = new JButton("2");
	private JButton bouton3 = new JButton("+");
	private JButton bouton4 = new JButton("=");
	private JButton bouton5 = new JButton("C");
	private JButton bouton6 = new JButton("*");
	private JButton bouton7 = new JButton("-");
	private JButton bouton8 = new JButton("/");
	private JButton boutontrois = new JButton("3");
	private JButton boutonquatre = new JButton("4");
	private JButton boutoncinq = new JButton("5");
	private JButton boutonsix = new JButton("6");
	private JButton boutonsept = new JButton("7");
	private JButton boutonhuit = new JButton("8");
	private JButton boutonneuf = new JButton("9");
	private JButton boutonzero = new JButton("0");
	private JButton boutonp = new JButton(".");
	private JButton boutonNeg = new JButton("(-)");
	private JButton boutondel = new JButton("Del");
	private JButton boutonra = new JButton("√");
	private JLabel label = new JLabel("0");
	//conteneur qui va contenir nos Layouts, boutons et label
	private JPanel conteneur = new JPanel();
	//les variables de notre classe
	private double valeur1;
	private double valeur2;
	private String p = "."; 
	private String operateur;
	private double resultat;
	
    //Le constructeur par defaut de notre classe
	public Calculatrice() {
		this.setSize(400, 250);
		this.setTitle("Calculatrice");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//Action de nos boutons
		bouton.addActionListener(new Bouton1("1"));
		bouton3.addActionListener(new Boutonplus("+"));
		bouton2.addActionListener(new Bouton2("2"));
		bouton4.addActionListener(new Boutonegal());
		bouton5.addActionListener(new BoutonEf("0"));
		bouton5.setForeground(Color.red);
		bouton6.addActionListener(new Mult("*"));
		boutontrois.addActionListener(new Boutontrois("3"));
		boutonquatre.addActionListener(new Boutonquatre("4"));
		boutoncinq.addActionListener(new Boutoncinq("5"));
		boutonsix.addActionListener(new Boutonsix("6"));
		boutonsept.addActionListener(new Boutonsept("7"));
		boutonhuit.addActionListener(new Boutonhuit("8"));
		boutonneuf.addActionListener(new Boutonneuf("9"));
		boutonzero.addActionListener(new Boutonzero("0"));
		bouton7.addActionListener(new Sous("-"));
		bouton8.addActionListener(new Div("/"));
		boutonp.addActionListener(new Point());
		boutonra.addActionListener(new Racine("√"));
		boutondel.addActionListener(new Del());
		boutonNeg.addActionListener(new Boutonneg("-"));
		
		//----------------------------------------
		
		Font police = new Font("Tahoma", Font.BOLD, 18);
		label.setFont(police);
		label.setHorizontalAlignment(JLabel.CENTER);
		JPanel pan = new JPanel();
		pan.setBackground(Color.white);
		pan.add(label);
		conteneur.setBackground(Color.LIGHT_GRAY);
		conteneur.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		
		//alignement du label
		g.fill = GridBagConstraints.HORIZONTAL;
		g.gridx = 0;
		g.gridy = 0;
		g.ipady = 4;
		g.gridy = 0;
				
		conteneur.add(pan, g);
		
		//alignement des boutons
		g.fill = GridBagConstraints.HORIZONTAL;
		
		
		g.gridx = 0;// P... ligne
		g.gridy = 2;
		conteneur.add(bouton5, g);
		g.gridy = 3;//d.... ligne
		conteneur.add(boutontrois, g);
		g.gridy = 4;
		conteneur.add(boutonsix, g);
		g.gridy = 5;
		conteneur.add(boutonneuf, g);
		g.gridy = 6;
		conteneur.add(boutonra, g);
	//-----------------------------------------------
		g.fill = GridBagConstraints.HORIZONTAL;
		
		g.gridx = 1;
		
		g.gridy = 2;
		conteneur.add(bouton, g);
		g.gridy = 3;
		conteneur.add(boutonquatre, g);
		g.gridy = 4;
		conteneur.add(boutonsept, g);
		g.gridy = 5;
		conteneur.add(boutonzero, g);
		g.gridy = 6;
		conteneur.add(boutonNeg, g);
		//-----------------------------------------------
		g.fill = GridBagConstraints.HORIZONTAL;
		
		g.gridx = 2;
		
		g.gridy = 2;
		conteneur.add(bouton2, g);
		g.gridy = 3;
		conteneur.add(boutoncinq, g);
		g.gridy = 4;
		conteneur.add(boutonhuit, g);
		g.gridy = 5;
		conteneur.add(boutonp, g);
		g.gridy = 6;
		conteneur.add(boutondel, g);
		//-----------------------------------------------
		g.fill = GridBagConstraints.HORIZONTAL;
		
		g.gridx = 3;
		
		g.gridy = 2;
		conteneur.add(bouton3, g);
		g.gridy = 3;
		conteneur.add(bouton6, g);
		g.gridy = 4;
		conteneur.add(bouton7, g);
		g.gridy = 5;
		conteneur.add(bouton8, g);
		g.gridy = 6;
		conteneur.add(bouton4, g);
		//-----------------------------------------------
		this.setContentPane(conteneur);
		this.setVisible(true);
	}
	
	//Les classes internes qui vont ecoutes les actions de nos boutons
	class Bouton1 implements ActionListener{
		private String chif;
		public Bouton1(String chif) {
			this.chif = chif;
		}
	
		
		public void actionPerformed(ActionEvent argO) {
			if(label.getText().equals("0")) {
				label.setText(chif);
			}
			else {
				label.setText(label.getText() + chif); //Nos chiffres vont se concatener
			}
			valeur2 = Double.parseDouble(label.getText());
			
		}
		
	}
	
	//deuxieme bouton
	class Boutonplus implements ActionListener{
		private String op;
		public Boutonplus(String op) {
			this.op = op;
		}
		public void actionPerformed(ActionEvent argO) {
			valeur1 = Double.parseDouble(label.getText());
			operateur = op;
			label.setText("0");
			
		}
	}
	
	//boutons
	class Bouton2 implements ActionListener{
		private String chif;
		
		public Bouton2(String chif) {
			this.chif = chif;
		}
		public void actionPerformed(ActionEvent argO) {
			if(label.getText().equals("0")) {
				label.setText(chif);
			}
			else {
				label.setText(label.getText() + chif);
			}
			valeur2 = Double.parseDouble(label.getText());
			
	   }
	}
	class Boutonegal implements ActionListener{
		public void actionPerformed(ActionEvent argO) {
			
			resultat = 0;
				if(operateur.equals("+")) {
					resultat = valeur1 + valeur2;
					label.setText(String.valueOf(resultat));
				}
				if(operateur.equals("*")) {
					resultat = valeur1 * valeur2;
					label.setText(String.valueOf(resultat));
				}
				if(operateur.equals("-")) {
					resultat = valeur1 - valeur2;
					label.setText(String.valueOf(resultat));
				}
				if(operateur.equals("/")) {
					resultat = valeur1 / valeur2;
					if(valeur2 == 0) {
						label.setText("Erreur !");
					}
					else {
						label.setText(String.valueOf(resultat));
					}
					

					
				}
			
			valeur1 = resultat;
			valeur2 = 0;
			operateur = null;
			//label.setText(String.valueOf(resultat));
					
				
		}
	}
	
	class BoutonEf implements ActionListener{
		private String op;
		public BoutonEf(String op) {
			this.op = op;
		}
		public void actionPerformed(ActionEvent argO) {
			
				valeur1 = 0;
				valeur2 = 0;
				resultat = 0;
				label.setText("0");
		}
	}
	
	class Mult implements ActionListener{
		private String op;
		public Mult(String op) {
			this.op = op;
		}
		public void actionPerformed(ActionEvent argO) {
			valeur1 = Double.parseDouble(label.getText());
			operateur = op;
			label.setText("0");
			
		}
	}
	
	class Boutontrois implements ActionListener{
		private String chif;
		public Boutontrois(String chif) {
			this.chif = chif;
		}
		public void actionPerformed(ActionEvent argO) {
			if(label.getText().equals("0")) {
				label.setText(chif);
			}
			else {
				label.setText(label.getText() + chif);
			}
			valeur2 = Double.parseDouble(label.getText());
			
		}
	}
	
	class Boutonquatre implements ActionListener{
		private String chif;
		public Boutonquatre(String chif) {
			this.chif = chif;
		}
		public void actionPerformed(ActionEvent argO) {
			if(label.getText().equals("0")) {
				label.setText(chif);
			}
			else {
				label.setText(label.getText() + chif);
			}
			valeur2 = Double.parseDouble(label.getText());
		
		}
	}
	
	class Boutoncinq implements ActionListener{
		private String chif;
		public Boutoncinq(String chif) {
			this.chif = chif;
		}
		public void actionPerformed(ActionEvent argO) {
			if(label.getText().equals("0")) {
				label.setText(chif);
			}
			else {
				label.setText(label.getText() + chif);
			}
			valeur2 = Double.parseDouble(label.getText());
	
		}
	}
	
	class Boutonsix implements ActionListener{
		private String chif;
		public Boutonsix(String chif) {
			this.chif = chif;
		}
		public void actionPerformed(ActionEvent argO) {
			if(label.getText().equals("0")) {
				label.setText(chif);
			}
			else {
				label.setText(label.getText() + chif);
			}
			valeur2 = Double.parseDouble(label.getText());
			
		}
	}
	
	class Boutonsept implements ActionListener{
		private String chif;
		public Boutonsept(String chif) {
			this.chif = chif;
		}
		public void actionPerformed(ActionEvent argO) {
			if(label.getText().equals("0")) {
				label.setText(chif);
			}
			else {
				label.setText(label.getText() + chif);
			}
			valeur2 = Double.parseDouble(label.getText());
			
		}
	}
	
	class Boutonhuit implements ActionListener{
		private String chif;
		public Boutonhuit(String chif) {
			this.chif = chif;
		}
		public void actionPerformed(ActionEvent argO) {
			if(label.getText().equals("0")) {
				label.setText(chif);
			}
			else {
				label.setText(label.getText() + chif);
			}
			valeur2 = Double.parseDouble(label.getText());
		
		}
	}
	
	class Boutonneuf implements ActionListener{
		private String chif;
		public Boutonneuf(String chif) {
			this.chif = chif;
		}
		public void actionPerformed(ActionEvent argO) {
			if(label.getText().equals("0")) {
				label.setText(chif);
			}
			else {
				label.setText(label.getText() + chif);
			}
			valeur2 = Double.parseDouble(label.getText());
		
		}
	}
	
	class Boutonzero implements ActionListener{
		private String chif;
		public Boutonzero(String chif) {
			this.chif = chif;
		}
		public void actionPerformed(ActionEvent argO) {
			if(label.getText().equals("0")) {
				label.setText(chif);
			}
			else {
				label.setText(label.getText() + chif);
			}
			valeur2 = Double.parseDouble(label.getText());
				
		}
	}
	
	class Div implements ActionListener{
		private String op;
		public Div(String op) {
			this.op = op;
		}
		public void actionPerformed(ActionEvent argO) {
			valeur1 = Double.parseDouble(label.getText());
			operateur = op;
			label.setText("0");
				
		}
	}
	
	class Sous implements ActionListener{
		private String op;
		public Sous(String op) {
			this.op = op;
		}
		public void actionPerformed(ActionEvent argO) {
			valeur1 = Double.parseDouble(label.getText());
			operateur = op;
			label.setText("0");
			
		}
	}
	
	class Point implements ActionListener{
		public void actionPerformed(ActionEvent argO) {
            if (!label.getText().contains(".")) {
                label.setText(label.getText() + ".");
            }
        }
	}
	
	class Racine implements ActionListener{
		private String op;
		public Racine(String op) {
			this.op = op;
		}
		public void actionPerformed(ActionEvent argO) {
			valeur1 = Double.parseDouble(label.getText());
			double ra = Math.sqrt(valeur1);
			label.setText(String.valueOf(ra));		
			
		}
	}
	
	class Del implements ActionListener{
	
		public void actionPerformed(ActionEvent argO) {
			String text = label.getText();
			if(text.length() > 1) {
				label.setText(text.substring(0, text.length() - 1));
			}
			
		}
			
	}
	
	class Boutonneg implements ActionListener{
		private String neg;
		public Boutonneg(String neg) {
			this.neg = neg;
		}
		public void actionPerformed(ActionEvent argO) {
			if(label.getText().equals("0")) {
				label.setText(neg);
			}
			else {
				try {
	                double currentValue = Double.parseDouble(label.getText());
	                label.setText(String.valueOf(-currentValue)); // Inverser le signe  
	            } catch (NumberFormatException e) {
	                // Gérer le cas où le texte n'est pas un nombre valide  
	                System.err.println("Erreur lors de la conversion en nombre: " + e.getMessage());
	            }
	        }
	        try {
	            valeur2 = Double.parseDouble(label.getText());
	        } catch (NumberFormatException e) {
	            // Ne rien faire ou afficher un message d'erreur  
	            System.err.println("Erreur lors de la conversion de la valeur2 en nombre: " + e.getMessage());
	        }
				
		}
		
	}
	public static void main(String[] args) {
		Calculatrice ca = new Calculatrice();
	}
}