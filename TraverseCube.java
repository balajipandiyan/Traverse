import java.util.*;

public class TraverseCube {

	public static List<String> treeTraverseHierarchy = new ArrayList<String>();//hierarachy of the current node in recursive function

	public static List<String> treeTraversePathList = new ArrayList<String>();//list of all possible traverse path,we can derive lowest path from this

	public static String getStringfromInteger(int xAxis, int yAxis) {
		return (Integer.toString(xAxis) + Integer.toString(yAxis));
	}

	public static String getStringfromIntegerComma(int xAxis, int yAxis) {
		return (Integer.toString(xAxis) + "," + Integer.toString(yAxis));
	}

	public static void traverse2DimensionsArray(int[][] cubeTraverse,
			int numberofRows, int numberofColumns) {
		//converting 2 d array to hash map for future reference of values
		HashMap<String, Integer> traverseMap = new HashMap<String, Integer>();
		for (int i = 0; i < numberofRows; i++) {
			for (int j = 0; i < numberofColumns; j++) {
				String Key = getStringfromInteger(i, j);
				traverseMap.put(Key, cubeTraverse[i][j]);
			}
		}
		
		//call recursive function for all left most values
		for (int i = 0; i < numberofRows-1; i++)
		{
			getNextNodeslist(i,0,numberofRows,numberofColumns);
		}
	}

	//Recursive function to find all possible traverse path of a given left most node
	public static void getNextNodeslist(int xCoordinate, int yCoordinate,
			int numberofRows, int numberofColumns) {
		String hierarachycoodinates = getStringfromIntegerComma(xCoordinate,
				yCoordinate);
		treeTraverseHierarchy.add(hierarachycoodinates);

		if (yCoordinate == numberofColumns - 1) {
			treeTraversePathList.add(treeTraverseHierarchy.toString());
			treeTraverseHierarchy.remove(hierarachycoodinates);
			return;
		}
		if (xCoordinate == 0)// adjacent rows
		{
			String forwardCoordinate = getStringfromIntegerComma(xCoordinate,
					yCoordinate + 1);
			String diagonalCoordinate1 = getStringfromIntegerComma(
					xCoordinate + 1, yCoordinate + 1);
			String diagonalCoordinate2 = getStringfromIntegerComma(
					numberofRows - 1, yCoordinate + 1);
			List<String> nextSetOfNodes = new ArrayList<String>();
			if (yCoordinate <= numberofColumns - 1) {
				nextSetOfNodes.add(forwardCoordinate);
				nextSetOfNodes.add(diagonalCoordinate1);
				nextSetOfNodes.add(diagonalCoordinate2);
				nextSetOfNodes.add(null);

			} else {
				nextSetOfNodes.add(forwardCoordinate);
				nextSetOfNodes.add(diagonalCoordinate1);
				nextSetOfNodes.add(diagonalCoordinate2);
			}
			for (String node : nextSetOfNodes) {
				if (node == null) {
					treeTraversePathList.add(treeTraverseHierarchy.toString());
									} 
				   else {
					String Coordinates[] = node.split(",");
					getNextNodeslist(Integer.parseInt(Coordinates[0]),
							Integer.parseInt(Coordinates[1]), numberofRows,
							numberofColumns);
				}
			}
		} else if (xCoordinate == numberofRows - 1)// adjacent rows
		{
			String forwardCoordinate = getStringfromIntegerComma(xCoordinate,
					yCoordinate + 1);
			String diagonalCoordinate1 = getStringfromIntegerComma(0,
					yCoordinate + 1);
			String diagonalCoordinate2 = getStringfromIntegerComma(
					numberofRows - 1, yCoordinate + 1);
			List<String> nextSetOfNodes = new ArrayList<String>();
			if (yCoordinate <= numberofColumns - 1) {
				nextSetOfNodes.add(forwardCoordinate);
				nextSetOfNodes.add(diagonalCoordinate1);
				nextSetOfNodes.add(diagonalCoordinate2);
				nextSetOfNodes.add(null);

			} else {
				nextSetOfNodes.add(forwardCoordinate);
				nextSetOfNodes.add(diagonalCoordinate1);
				nextSetOfNodes.add(diagonalCoordinate2);
			}
			for (String node : nextSetOfNodes) {
				if (node == null) {
					treeTraversePathList.add(treeTraverseHierarchy.toString());
					
				} else {
					String Coordinates[] = node.split(",");
					getNextNodeslist(Integer.parseInt(Coordinates[0]),
							Integer.parseInt(Coordinates[1]), numberofRows,
							numberofColumns);
				}
			}
		} else {
			String forwardCoordinate = getStringfromIntegerComma(xCoordinate,
					yCoordinate + 1);
			String diagonalCoordinate1 = getStringfromIntegerComma(
					xCoordinate - 1, yCoordinate + 1);
			String diagonalCoordinate2 = getStringfromIntegerComma(
					xCoordinate + 1, yCoordinate + 1);
			List<String> nextSetOfNodes = new ArrayList<String>();
			if (yCoordinate <= numberofColumns - 1) {
				nextSetOfNodes.add(forwardCoordinate);
				nextSetOfNodes.add(diagonalCoordinate1);
				nextSetOfNodes.add(diagonalCoordinate2);
				nextSetOfNodes.add(null);

			} else {
				nextSetOfNodes.add(forwardCoordinate);
				nextSetOfNodes.add(diagonalCoordinate1);
				nextSetOfNodes.add(diagonalCoordinate2);
			}
			for (String node : nextSetOfNodes) {
				String Coordinates[] = node.split(",");
				getNextNodeslist(Integer.parseInt(Coordinates[0]),
						Integer.parseInt(Coordinates[1]), numberofRows,
						numberofColumns);

			}
		}

		treeTraverseHierarchy.remove(hierarachycoodinates);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] Row0 = { "4", "6", "9", "5" };
		String[] Row1 = { "4", "6", "9", "5" };
		String[] Row2 = { "4", "6", "9", "5" };
		int numberofRows = 4;
		int numberofColumns = 3;

		List<String[]> inputList = new ArrayList<String[]>();

		inputList.add(Row0);
		inputList.add(Row1);
		inputList.add(Row2);

		int[] cubeValues = new int[numberofRows * numberofColumns];

		int incrementCubeValuesArray = 0;

		
		//converting input list in to array of values
		for (int loopInputList = 0; loopInputList < inputList.size(); loopInputList++) {

			String[] inputRow = inputList.get(loopInputList);
			for (int inputRowList = 0; inputRowList < inputRow.length; inputRowList++) {
				cubeValues[incrementCubeValuesArray] = Integer
						.parseInt(inputRow[inputRowList]);
				incrementCubeValuesArray++;
			}

		}

		int[][] traverseCubeArray = new int[numberofRows][numberofColumns];

		int incrementCubeValues2Dimension = 0;
         
		//Converting one dimnesional input in to 2 dimensional cube of values
		
		for (int xAxis = 0; xAxis < numberofRows - 1; xAxis++) {
			for (int yAxis = 0; yAxis < numberofColumns - 1; yAxis++) {
				traverseCubeArray[xAxis][yAxis] = cubeValues[incrementCubeValues2Dimension];
				incrementCubeValues2Dimension++;
			}
		}
		
		TraverseCube.traverse2DimensionsArray(traverseCubeArray, numberofRows, numberofColumns);

	}

}
