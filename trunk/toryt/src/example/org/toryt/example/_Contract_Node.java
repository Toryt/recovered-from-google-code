package org.toryt.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.toryt.Cases;
import org.toryt.Condition;
import org.toryt.MethodTest;
import org.toryt.TorytException;
import org.toryt.hard.ClassContract;
import org.toryt.hard.MutatorContract;


public class _Contract_Node extends ClassContract {

  public _Contract_Node() throws TorytException {
    super(Node.class);
    setSuperClassContract("java.lang.Object");
    addInstanceMethodContract(new MutatorContract(this, Node.class, "setDescription(java.lang.String)") {

      public String[] getFormalParameters() {
        return new String[] {"description"};
      }

      {
        addPostcondition(new Condition() {
          public boolean validate(Map context) {
            Node subject = (Node)context.get(SUBJECT_KEY); 
            String description = (String)context.get("description");
            boolean result = subject.getDescription().equals(description == null ? "" : description);
            return result;
          }});
      }
      
      public List getTestCases() throws TorytException {
        List result = new ArrayList();
        Iterator subjects = getCases().iterator();
        while (subjects.hasNext()) {
          Node subject = (Node)subjects.next();
          Iterator descriptions = Cases.findTestObjectList(String.class).iterator();
          while (descriptions.hasNext()) {
            String description = (String)descriptions.next();
            Map testCase = new HashMap();
            testCase.put(SUBJECT_KEY, subject);
            testCase.put("description", description);
            result.add(testCase);
          }
        }
        return result;
      }

    });
    addInstanceMethodContract(new MutatorContract(this, Node.class, "setTitle(java.lang.String)") {

      public String[] getFormalParameters() {
        return new String[] {"title"};
      }
      
      {
        addPostcondition(new Condition() {
          public boolean validate(Map context) {
            Node subject = (Node)context.get(SUBJECT_KEY); 
            String title = (String)context.get("title");
            return subject.getTitle().equals(title == null ? "" : title);
          }});
      }

      public List getTestCases() throws TorytException {
        List result = new ArrayList();
        Iterator subjects = getCases().iterator();
        while (subjects.hasNext()) {
          Node subject = (Node)subjects.next();
          Iterator titles = Cases.findTestObjectList(String.class).iterator();
          while (titles.hasNext()) {
            String title = (String)titles.next();
            Map testCase = new HashMap();
            testCase.put(SUBJECT_KEY, subject);
            testCase.put("title", title);
            result.add(testCase);
          }
        }
        return result;
      }
      
    });
    addInstanceMethodContract(new MutatorContract(this, Node.class, "setGroup(org.toryt.example.Group)") {

      public String[] getFormalParameters() {
        return new String[] {"group"};
      }
      
      {
        addPostcondition(new Condition() {
          public boolean validate(Map context) {
            Node subject = (Node)context.get(SUBJECT_KEY); 
            Group group = (Group)context.get("group");
            return subject.getGroup() == group;
          }});
        addPostcondition(new Condition() {
          public boolean validate(Map context) {
            Node subject = (Node)context.get(SUBJECT_KEY); 
            Group oldGroup = (Group)context.get("getGroup()@pre"); 
            return oldGroup != null ? ! oldGroup.getNodes().values().contains(subject) : true;
          }});
        addPostcondition(new Condition() {
          public boolean validate(Map context) {
            Node subject = (Node)context.get(SUBJECT_KEY); 
            Group group = (Group)context.get("group");
            return group != null ? group.getNodes().values().contains(subject) : true;
          }});
      }

      public List getTestCases() throws TorytException {
        List result = new ArrayList();
        Iterator subjects = getCases().iterator();
        while (subjects.hasNext()) {
          Node subject = (Node)subjects.next();
          Iterator groups = new _Contract_Group().getCasesWithNull().iterator();
          while (groups.hasNext()) {
            Group group = (Group)groups.next();
            Map testCase = new HashMap();
            testCase.put(SUBJECT_KEY, subject);
            testCase.put("group", group);
            result.add(testCase);
          }
        }
        return result;
      }
      
      public void recordState(MethodTest test) {
        Map state = test.getContext();
        Node subject = (Node)state.get(SUBJECT_KEY); 
        state.put("getGroup()@pre",subject.getGroup());
      }
      
    });
    addBasicInspector("getDescription()");
    addBasicInspector("getTitle()");
    addBasicInspector("getRating()");
    addBasicInspector("getGroup()");
    close();
  }
  
  public void validateTypeInvariants(Object subject, MethodTest t) {
    assert getType().isInstance(subject);
    Node n = (Node)subject;
    t.validate(n.getTitle() != null);
    t.validate(n.getDescription() != null);
    t.validate(! Double.isNaN(n.getRating()) ? (n.getRating() >= 0) : true);
    t.validate(! Double.isNaN(n.getRating()) ? (n.getRating() <= 10) : true);
    t.validate((n.getGroup() != null)
                   ? n.getGroup().getNodes().get(n.getTitle()) == n
                   : true);
  }

  public List getCases() throws TorytException {
    return getCases(new NodeFactory());
  }

  public static List getCases(NodeFactory nf) throws TorytException {
    List result = new ArrayList();
    Iterator descriptions = Cases.findTestObjectList(String.class).iterator();
    while (descriptions.hasNext()) {
      String description = (String)descriptions.next();
      Iterator titles = Cases.findTestObjectList(String.class).iterator();
      while (titles.hasNext()) {
        String title = (String)titles.next();
        // If we just use the group cases, we get an infinite loop
        result.add(nf.createNode(description, title, null));
        result.add(nf.createNode(description, title, new Group()));
        result.add(nf.createNode(description, title, new Group("title","description",null)));
        result.add(nf.createNode(description, title, new Group("title","description",new Group())));
      }
    }
    return result;
  }
  
  public static class NodeFactory {
    
    public Node createNode() {
      return new NodeStub();
    }

    public Node createNode(String description, String title, Group group) {
      Node subject = createNode();
      subject.setDescription(description);
      subject.setTitle(title);
      subject.setGroup(group);
      return subject;
    }
    
  }
  
  private static class NodeStub extends Node {

    protected int getTotalOfRatings() {
      return 0;
    }

    protected int getNumberOfBookmarks() {
      return 0;
    }
    
  }
  
}