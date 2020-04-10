package addTemaTest;

import addStudentTest.domain.Nota;
import addStudentTest.domain.Student;
import addStudentTest.domain.Tema;
import addStudentTest.repository.NotaXMLRepository;
import addStudentTest.repository.StudentXMLRepository;
import addStudentTest.repository.TemaXMLRepository;
import addStudentTest.service.Service;
import addStudentTest.validation.NotaValidator;
import addStudentTest.validation.StudentValidator;
import addStudentTest.validation.TemaValidator;
import addStudentTest.validation.Validator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTestIntegration
{
    /**
     * Rigorous Test :-)
     */
    private StudentXMLRepository rep1;
    private NotaXMLRepository rep2;
    private TemaXMLRepository rep3;
    private Service srv;

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void addAssignmentTest(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        rep1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        rep3 = new TemaXMLRepository(temaValidator, "teme.xml");
        rep2 = new NotaXMLRepository(notaValidator, "note.xml");
        srv = new Service(rep1, rep3, rep2);
        int result = srv.saveTema("123","asd",10, 7);
        assertEquals(1, result);
    }

    @Test
    public void addStudentTest(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        rep1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        rep3 = new TemaXMLRepository(temaValidator, "teme.xml");
        rep2 = new NotaXMLRepository(notaValidator, "note.xml");
        srv = new Service(rep1, rep3, rep2);
        int result = srv.saveStudent("515", "asd", 936);
        assertEquals(1, result);
        srv.deleteStudent("515");
    }

    @Test
    public void addGradeTest(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        rep1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        rep3 = new TemaXMLRepository(temaValidator, "teme.xml");
        rep2 = new NotaXMLRepository(notaValidator, "note.xml");
        srv = new Service(rep1, rep3, rep2);
        int result = srv.saveNota("400", "121", 9, 10, "Bun");
        assertEquals(1, result);
    }

    @Test
    public void bigBangTest(){
        addStudentTest();
        addAssignmentTest();
        addGradeTest();
    }

}



