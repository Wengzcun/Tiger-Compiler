import java.io.*;

import syntaxtree.*;
import visitor.*;

public class Main {
	public static void main(String[] args) {
		try {
			/*
			// File file = new File("C:\\tiger2\\testcases\\BinarySearch.java");
			// File file = new File("C:\\tiger2\\testcases\\BinaryTree.java");
			// File file = new File("C:\\tiger2\\testcases\\BubbleSort.java");
			// File file = new File("C:\\tiger2\\testcases\\Factorial.java");
			// File file = new File("C:\\tiger2\\testcases\\Factorial2.java");
			// //has duplicate var decl.
			// File file = new File("C:\\tiger2\\testcases\\LinearSearch.java");
			// File file = new File("C:\\tiger2\\testcases\\LinkedList.java");
			// File file = new File("C:\\tiger2\\testcases\\QuickSort.java");
			// File file = new File("C:\\tiger2\\testcases\\Test1.java");
			// File file = new File("C:\\tiger2\\testcases\\TreeVisitor.java");

			File file = new File("C:\\tiger2\\testcases\\blah.java");

			FileInputStream stream = new FileInputStream(file);
			Program root = new MiniJavaParser(stream).Goal();

			// Program root = new MiniJavaParser(System.in).Goal();
			BuildSymbolTableVisitor bstv = new BuildSymbolTableVisitor();
			root.accept(bstv); // create symbol table
			if (!bstv.error.anyErrors) {
				bstv.symbolTable.dumpContents();

				TypeCheckVisitor tcv = new TypeCheckVisitor(bstv.symbolTable);
				root.accept(tcv); // do type checks
				if (tcv.error.anyErrors) {
					System.out
							.println("Type-checking completed (with errors).");
				} else {
					System.out.println("Type-checking successful.");
				}
			}*/
			
			

			/**/File dir = new File("C:\\tiger2\\testcases\\");
			String[] children = dir.list();
			boolean firstRun = true;
			for (int i = 0; i < children.length; i++) {
				// Get filename of file or directory
				String filename = children[i];
				if (filename.endsWith(".java")) {
					System.out.println(filename + ": ");
					File file = new File("C:\\tiger2\\testcases\\" + filename);
					FileInputStream stream = new FileInputStream(file);
					if (firstRun) {
						new MiniJavaParser(stream);
						firstRun = false;
					} else {
						MiniJavaParser.ReInit(stream);
					}
					Program root = MiniJavaParser.Goal();
					BuildSymbolTableVisitor bstv = new BuildSymbolTableVisitor();
					root.accept(bstv); // create symbol table
					if (!bstv.error.anyErrors) {
						// bstv.symbolTable.dumpContents();
						TypeCheckVisitor tcv = new TypeCheckVisitor(bstv.symbolTable);
						root.accept(tcv); // do type checks
						if (tcv.error.anyErrors) {
							System.out
									.println("\tType-checking completed (with errors).");
						} else {
							 System.out.println("\tType-checking successful.");
						}
					}
					
					
					///Uncomment this to pretty-print the output to the console:
					/*PrettyPrintVisitor ppv = new PrettyPrintVisitor();
					root.accept(ppv);
					System.out.println("");*/
					
					
					
				}
			}// end for

		} catch (ParseException e) {
			System.out.println(e.toString());
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found!");
		}
	}
}
