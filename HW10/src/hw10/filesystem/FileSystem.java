package hw10.filesystem;

public abstract class FileSystem {

    protected String name;
    protected int Capacity;
    protected int id;
    protected FSElement root;

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.Capacity;
    }

    public int getId() {
        return this.id;
    }

    protected void setRoot(FSElement root) {
        this.root = root;
    }

    public FSElement getRoot() {
        return this.root;
    }

    protected abstract FSElement createDefaultRoot();

    public FSElement initFS(String name, int capacity) {
        this.name = name;
        this.Capacity = capacity;
        FSElement root = createDefaultRoot();
        if(root.isDirectory() && capacity >= root.getSize()) {
            setRoot(root);
            this.id = root.hashCode();
            return root;
        }
        else {
            return null;
        }
    }
}
