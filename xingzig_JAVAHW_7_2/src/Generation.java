public class Generation {
	
	/** A container of GPTrees. */
    public class Generation {
        private int numTrees;
        private GPTree[] population;
        private double[] fitness;

        /** Specifies the number of GPTrees in this generation, the
        * factories used to generate the individual trees, the maximum tree depth,
        * and the Random object used. */
        Generation(int numTrees, OperatorFactory o, TerminalFactory t, int m, Random r) {
            this.numTrees = numTrees;
            population = new GPTree[numTrees];
            fitness = new double[numTrees];
            for (int i = 0; i < numTrees; i++)
            population[i] = new GPTree(o, t, m, r);
        }
        Generation(int n) {
            numTrees = n;
            population = new GPTree[numTrees];
            fitness = new double[numTrees];
        }


        /** Evaluate each tree in this generation, and set each tree's fitness value. */
        public void evalAll(DataSet theData) {
            // You need to write this
        }

        public GPTree getTree(int i) {
            return population[i];
        }

        ** Prints the tree with the lowest fitness value. */
        public void printBestTree() {
            // You need to write this
        }
        public int getNumTrees() { return numTrees; }
        public void printGeneration() {
            for (int i = 0; i < numTrees; i++) {
                System.out.println(population[i]);
            }
        }