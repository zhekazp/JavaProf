package org.task3.RequstDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.task3.entity.Roots;
@Data
@AllArgsConstructor
public class RequestRootDTO {
   private Integer id;
   private Roots root;
}
