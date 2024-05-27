package co.edu.uniquindio.model.estructurasDeDatos.Tree;

import co.edu.uniquindio.model.Author;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree<Author> tree;

    @BeforeEach
    void setUp() {
        tree = new BinaryTree<>();
    }

    @AfterEach
    void tearDown() {
        tree = null;
    }

    @Test
    void insert() {
        Author autor1 = new Author();
        autor1.setName("Gabriel García Márquez");
        tree.insert(autor1);
        assertTrue(tree.exists(autor1));
    }

    @Test
    void exists() {
        Author autor1 = new Author();
        autor1.setName("Gabriel García Márquez");
        Author autor2 = new Author();
        autor2.setName("Mario Vargas Llosa");
        tree.insert(autor1);
        assertTrue(tree.exists(autor1));
        assertFalse(tree.exists(autor2));
    }

    @Test
    void obtener() {
        Author autor1 = new Author();
        autor1.setName("Gabriel García Márquez");
        Author autor2 = new Author();
        autor2.setName("Mario Vargas Llosa");
        tree.insert(autor1);
        tree.insert(autor2);
        assertEquals(autor1, tree.obtener("Gabriel García Márquez"));
        assertEquals(autor2, tree.obtener("Mario Vargas Llosa"));
        assertNull(tree.obtener("Isabel Allende"));
    }

    @Test
    void find() {
        Author autor1 = new Author();
        autor1.setName("Gabriel García Márquez");
        Author autor2 = new Author();
        autor2.setName("Mario Vargas Llosa");
        tree.insert(autor1);
        tree.insert(autor2);
        assertEquals(autor1, tree.find(autor1));
        System.out.println("find: "+tree.find(autor1));
        assertEquals(autor2, tree.find(autor2));
        System.out.println("find: "+tree.find(autor2));
        Author autor3 = new Author();
        autor3.setName("Isabel Allende");
        assertNull(tree.find(autor3));
    }

    @Test
    void size() {
        assertEquals(0, tree.size());
        Author autor1 = new Author();
        autor1.setName("Gabriel García Márquez");
        Author autor2 = new Author();
        autor2.setName("Mario Vargas Llosa");
        tree.insert(autor1);
        assertEquals(1, tree.size());
        System.out.println("size: "+tree.size());
        tree.insert(autor2);
        assertEquals(2, tree.size());
        System.out.println("size: "+tree.size());
    }

    @Test
    void isEmpty() {
        assertTrue(tree.isEmpty());
        Author autor1 = new Author();
        autor1.setName("Gabriel García Márquez");
        tree.insert(autor1);
        assertFalse(tree.isEmpty());
        System.out.println("isEmpty: "+tree.isEmpty());
    }
}