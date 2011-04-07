package org.zmlx.hg4idea.command;

import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nullable;
import org.zmlx.hg4idea.execution.HgCommandResult;
import org.zmlx.hg4idea.execution.HgCommandExecutor;

import java.util.ArrayList;
import java.util.List;

public class HgCloneCommand {
  private final Project project;

  private String repositoryURL;
  private String directory;

  public HgCloneCommand(Project project) {
    this.project = project;
  }

  public void setDirectory(String directory) {
    this.directory = directory;
  }

  public void setRepositoryURL(String repositoryURL) {
    this.repositoryURL = repositoryURL;
  }

  @Nullable
  public HgCommandResult execute() {
    final List<String> arguments = new ArrayList<String>(2);
    arguments.add(repositoryURL);
    arguments.add(directory);
    return new HgCommandExecutor(project).executeInCurrentThread(null, "clone", arguments);
  }
}
