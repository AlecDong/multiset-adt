public class Tree {
    public double average() {
        if (this.is_empty()) {
            return 0.0;
        } else {
            int[] helper_results = this._average_helper();
            return (double) helper_results[0] / helper_results[1];
        }
    }

    private int[] _average_helper() {
        if (this.is_empty()) {
            return new int[] {0, 0};
        } else {
            int total = this._root;
            int size = 1;
            for (subtree : this._subtrees) {
                int[] helper_results = subtree._average_helper();
                total += helper_results[0];
                size += helper_results[1];
            }
            return new int[] {total, size};
        }
    }

    @Override
    public boolean equals(Tree tree) {
        if (this.is_empty() && tree.is_empty()) {
            return true;
        } else if (this.is_empty() || tree.is_empty()) {
            return false;
        } else {
            if (this._root != tree._root) {
                return false;
            }

            if (this._subtrees.size() != tree._subtrees.size()) {
                return false;
            }

            return this._subtrees == tree._subtrees;
        }
    }
}
