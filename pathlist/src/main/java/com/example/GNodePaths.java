package com.example;

import java.util.ArrayList;
import java.util.List;

public class GNodePaths {

    public List<List<GNode>> paths(GNode node) {
        List<List<GNode>> result = new ArrayList<>();
        List<GNode> currentPath = new ArrayList<>();
        dfs(node, currentPath, result);
        return result;
    }

    private void dfs(GNode node, List<GNode> currentPath, List<List<GNode>> result) {
        currentPath.add(node);

        if (node.getChildren().isEmpty()) {
            result.add(new ArrayList<>(currentPath));
        } else {
            for (GNode child : node.getChildren()) {
                dfs(child, currentPath, result);
            }
        }

        currentPath.remove(currentPath.size() - 1);
    }

    // Example graph creation
    public static GNode createGraph() {
        GNode nodeA = new GNodeImpl("A");
        GNode nodeB = new GNodeImpl("B");
        GNode nodeC = new GNodeImpl("C");
        GNode nodeD = new GNodeImpl("D");
        GNode nodeE = new GNodeImpl("E");
        GNode nodeF = new GNodeImpl("F");
        GNode nodeG = new GNodeImpl("G");
        GNode nodeH = new GNodeImpl("H");
        GNode nodeI = new GNodeImpl("I");
        GNode nodeJ = new GNodeImpl("J");

        nodeA.getChildren().add(nodeB);
        nodeA.getChildren().add(nodeC);
        nodeA.getChildren().add(nodeD);
        nodeB.getChildren().add(nodeE);
        nodeB.getChildren().add(nodeF);
        nodeC.getChildren().add(nodeG);
        nodeC.getChildren().add(nodeH);
        nodeC.getChildren().add(nodeI);
        nodeD.getChildren().add(nodeJ);

        return nodeA;
    }
    public static void main( String[] args ) {
        GNode nodeA = createGraph();

        GNodePaths graphPaths = new GNodePaths();
        List<List<GNode>> paths = graphPaths.paths(nodeA);

        for (List<GNode> path : paths) {
            System.out.print("(");
            for (GNode node : path) {
                System.out.print(node.getName() + " ");
            }
            System.out.print(")");
        }
    }
}
