package com.oreilly.aspectjcookbook.oopatterns;

import java.util.Enumeration;
import java.util.WeakHashMap;
import java.util.Vector;

public abstract aspect CompositePattern 
{
	public interface Component {
	}

	protected interface Composite extends Component {
	}

	protected interface Leaf extends Component {
	}

	private WeakHashMap perComponentChildren = new WeakHashMap();

	private Vector getChildren(Component s) {
		Vector children = (Vector) perComponentChildren.get(s);
		if (children == null) {
			children = new Vector();
			perComponentChildren.put(s, children);
		}
		return children;
	}

	public void addChild(Composite composite, Component component) {
		getChildren(composite).add(component);
	}

	public void removeChild(Composite composite, Component component) {
		getChildren(composite).remove(component);
	}

	public Enumeration getAllChildren(Component c) {
		return getChildren(c).elements();
	}

	public interface Visitor 
	{
		public void doOperation(Component c);
	}

	public void recurseOperation(Component c, Visitor v) {
		for (Enumeration enum = getAllChildren(c); enum.hasMoreElements();) {
			Component child = (Component) enum.nextElement();
			v.doOperation(child);
		}
	}

	public interface FunctionVisitor 
	{
		public Object doFunction(Component c);
	}

	public Enumeration recurseFunction(Component c, FunctionVisitor fv) {
		Vector results = new Vector();
		for (Enumeration enum = getAllChildren(c); enum.hasMoreElements();) {
			Component child = (Component) enum.nextElement();
			results.add(fv.doFunction(child));
		}
		return results.elements();
	}
}
