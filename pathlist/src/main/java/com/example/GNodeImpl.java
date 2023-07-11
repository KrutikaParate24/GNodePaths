package com.example;

import java.util.ArrayList;
import java.util.List;

public class GNodeImpl implements GNode {

    private String name;
        private List<GNode> children;

        public GNodeImpl(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<GNode> getChildren() {
            return children;
        }

}
