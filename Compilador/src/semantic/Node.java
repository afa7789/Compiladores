/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantic;

/**
 *
 * @author Jonathan
 */
public class Node {
    public String type;
    public String identifier;
    
    public Node(String type, String identifier){
        this.type = type;
        this.identifier = identifier;
    }
}
