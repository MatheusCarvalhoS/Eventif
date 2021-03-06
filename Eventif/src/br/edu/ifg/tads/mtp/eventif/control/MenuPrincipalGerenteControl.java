package br.edu.ifg.tads.mtp.eventif.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.edu.ifg.tads.mtp.eventif.view.AppView;
import br.edu.ifg.tads.mtp.eventif.view.MenuPrincipalGerenteView;

public class MenuPrincipalGerenteControl {
	private JPanel menu;
	private MenuPrincipalGerenteView menuGerente;
	private AppView appView;
	public JPanel getMenuPrincipalGerente(AppView app){
		this.appView=app;
		menuGerente = new MenuPrincipalGerenteView();
		menu = menuGerente.getMenuPrincipalGerenteView();
		menuGerente.getEventos().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				appView.getPainelDireita().removeAll();
				appView.getPainelDireita().add(new GerenteListarEventoControl().getGerenteListarEventoControl(appView));
				appView.getPainelDireita().repaint();
			}
		});
		
		menuGerente.getJbtnNovoEvento().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				appView.getPainelDireita().removeAll();
				appView.getPainelDireita().add(new GerenteCriarEventoControl().getGerenteCriarEventoControl());
				appView.getPainelDireita().repaint();
			}
		});
		return menu;
	}
}
