package addStudentTest;

import static org.junit.Assert.assertTrue;
import addStudentTest.*;
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

/**
 * Unit test for simple App.
 */
public class AppTest 
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
    public void my_test_1(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        rep1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        rep3 = new TemaXMLRepository(temaValidator, "teme.xml");
        rep2 = new NotaXMLRepository(notaValidator, "note.xml");
        srv = new Service(rep1, rep3, rep2);
        int result = srv.saveStudent("25", "asd", 935);
        assertEquals(0, result);//id already exists
    }

    @Test
    public void my_test_2(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        rep1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        rep3 = new TemaXMLRepository(temaValidator, "teme.xml");
        rep2 = new NotaXMLRepository(notaValidator, "note.xml");
        srv = new Service(rep1, rep3, rep2);
        int result = srv.saveStudent("415", "asd", 936);
        assertEquals(1, result);}

}
