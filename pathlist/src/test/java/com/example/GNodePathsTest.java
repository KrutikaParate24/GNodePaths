package com.example;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GNodePathsTest
{
    @Test
    public void testPaths() {
        GNodeImpl nodeA = new GNodeImpl("A");
        GNodeImpl nodeB = new GNodeImpl("B");
        GNodeImpl nodeC = new GNodeImpl("C");
        GNodeImpl nodeD = new GNodeImpl("D");
        GNodeImpl nodeE = new GNodeImpl("E");
        GNodeImpl nodeF = new GNodeImpl("F");
        GNodeImpl nodeG = new GNodeImpl("G");
        GNodeImpl nodeH = new GNodeImpl("H");
        GNodeImpl nodeI = new GNodeImpl("I");
        GNodeImpl nodeJ = new GNodeImpl("J");

        nodeA.getChildren().add(nodeB);
        nodeA.getChildren().add(nodeC);
        nodeA.getChildren().add(nodeD);
        nodeB.getChildren().add(nodeE);
        nodeB.getChildren().add(nodeF);
        nodeC.getChildren().add(nodeG);
        nodeC.getChildren().add(nodeH);
        nodeC.getChildren().add(nodeI);
        nodeD.getChildren().add(nodeJ);

        GNodePaths paths = new GNodePaths();
        List<List<GNode>> result = paths.paths(nodeA);

        List<List<GNode>> expected = new ArrayList<>();
        expected.add(List.of(nodeA, nodeB, nodeE));
        expected.add(List.of(nodeA, nodeB, nodeF));
        expected.add(List.of(nodeA, nodeC, nodeG));
        expected.add(List.of(nodeA, nodeC, nodeH));
        expected.add(List.of(nodeA, nodeC, nodeI));
        expected.add(List.of(nodeA, nodeD, nodeJ));

        assertEquals(expected, result);
    }
}
