/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class UserModel {
   
    private int id;
    private String username;
    private String password;
    
    public UserModel (){
        
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username ;
    } 
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password ;
    }
}