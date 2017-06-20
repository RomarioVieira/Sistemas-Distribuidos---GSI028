package com;

import com.ThriftGenerate.Edge;
import com.ThriftGenerate.Vertex;
import com.ThriftGenerate.Methods;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

public class JavaClient {

    public static void main(String[] args) {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 1414);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            Methods.Client client = new Methods.Client(protocol);

            perform(client);

            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }

    private static void perform(Methods.Client client) throws TException {

        Vertex v1 = new Vertex();
        
        v1.idVertex = 1;
        v1.nameVertex = "Aninha";
        v1.version = 1;
        v1.color = "Vermelho";
        v1.description = "Qualquer coisa";
        v1.weight = 87;
        

        Vertex v2 = new Vertex();
        v2.idVertex = 2;
        v2.nameVertex = "Pedrinho";
        v2.version = 1;
        
        v1.color = "Amarelo";
        v1.description = "Qualquer coisa";
        v1.weight = 5;

        System.out.println(client.createVertex(v1));
        System.out.println(client.createVertex(v2));

        System.out.println(client.showBase());
    
        Edge edge = new Edge();
        
        edge.idEdge = 1;
        edge.nameEdge = "aresta";
        edge.version = 1;
        edge.idVertex1 = 1;
        edge.idVertex2 = 2;
        edge.description = "Qualquer coisa";
        edge.flagDirected = true;
        edge.weight = 5;
        
       
        System.out.println(client.showBase());
        
    }
}
