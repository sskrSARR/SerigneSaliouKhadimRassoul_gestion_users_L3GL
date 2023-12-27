package main;

import dao.UserImpl;
import dao.IUser;
import entity.User;
import dao.RoleImpl;
import dao.IRole;
import entity.Role;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IUser userDao = new UserImpl();
        IRole roleDao = new RoleImpl();

        boolean reponse=false;
        int choix,get;
        do {


        System.out.println("-----------------------M   E   N   U   ------------------");
        System.out.println("------------------1-Ajouter un user----------------------");
        System.out.println("------------------2-Listez Les users---------------------");

        do {
            System.out.println("FAITES VOTRE CHOIX");
            choix = scanner.nextInt();
        }while (choix<1 || choix >2);

        switch (choix){
            case 1:
                User u = new User();
                System.out.println("Donner l'email de l'utilisateur");
                String email = scanner.next();
                u.setEmail(email);
                System.out.println("Donner le mot de passe de l'utilisateur");
                String password = scanner.next();
                u.setPassword(password);
                System.out.println("Liste des roles");
                for (Role r : roleDao.list()) {
                    System.out.println("ID = " + r.getId());
                    System.out.println("email = " + r.getName());
                }
                System.out.println("Donner le role de l'utilisateur en choisissant l'id");
                int role = scanner.nextInt();
                u.setIdRole(role);
                int ok = userDao.add(u);
                if(ok == 1)
                    System.out.println("utilisateur enregistré avec succés !");
                else
                    System.out.println("Echec !");
            break;
            case 2 :
                System.out.println("Liste des users");
                for (User us : userDao.list()) {
                    System.out.println("ID: " + us.getId());
                    System.out.println("email: " + us.getEmail());
                    System.out.println("MDP: " + us.getPassword());
                    System.out.println("MDP-Hash: " + us.getPasswordHashed());
                    System.out.println("idRole: " + us.getIdRole());
                }
                break;

        }

            System.out.println("Voulez vous refaire une action si oui tapez 1 si non tapez 0");
            get= scanner.nextInt();
            reponse=get==1? true : false;
    }while (reponse);

    }
}