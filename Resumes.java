import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Resumes implements java.lang.Iterable<Resume>
{
  private List<Resume> resumes;

  public Resumes()
  {
    this.resumes = new ArrayList<>();
  }

  public Resumes(List<Resume> resumes)
  {
    this.resumes = resumes;
  }

  public void add(Resume resume)
  {
    resumes.add(resume);
  }

  @Override
  public Iterator<Resume> iterator()
  {
    return resumes.iterator();
  }

  public Resume resumeWithName(ResumeName name)
  {
    for( Resume resume : resumes )
    {
      if( resume.hasName(name) )
      {
        return resume;
      }
    }
    
    return Resume.invalid;
  }

};
