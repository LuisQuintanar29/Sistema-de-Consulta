# Sistema-de-Consulta
Sistema de Consulta en Java


Estructura de registros de los estudiantes:
        c1|c2,c3,c4|c5|c6|c7
  c1: Numero de cuenta
  c2: nombres
  c3: Apellido paterno
  c4: Apellido materno
  c5: Fecha de nacimiento
  c6: CURP
  c7: Nombre de la carrera
  
  
Estructura de registros de los profesores:
      c1|c2|c3,c4,c5|c6,c7,c8,c9,c10|c11|c16(1);c16(2);c16(3)
  c1: Numero de trabajador
  c2: Tipo de Porfesor (Asignatura, Carrera, Ordinario, Visitante, Extraordinario, Emerito )
  c3: Nonmbres
  c4: Apellido Paterno
  c5: Apellido Materno
  c6: Fecha de Nacimiento
  c7: CURP
  c8: RFC
  c9: Fecha de Contratación
  c10: Título ( Licenciatura, Mestria, Doctorado )
  c11: Entidad **1,4
  c12: Tipo de Investigador(TitularA, TitularB, TitularC) **1
  c13: Lista de Publicaciones  **1,3
  c14: Asignatura que imparte **2
  c15: Nacionalidad  **3
  c16: Lista de Contribuciones   **4
  c17: Lista de Tesis Dirigidas   **5,6
  c18: Clasificaion (Asociado, Titular)  **6
  c19: Lista de seminarios   **6
        ** 1. Campo de profesor Ordinario
        ** 2. Campo de profesor Visitante
        ** 3. Campo de profesor Extraordinario
        ** 4. Campo de profesor Emerito
        ** 5. Campo de profesor de Asignatura
        ** 6. Campo de profesor de Carrera


Estructura para la carga de proyectos:
      c1|c2|c3(1);c3(2);...|c4(1);c4(2);...
  c1: Clave del proyecto
  c2: Nombre del Proyecto
  c3: Lista de numeros de trabajador profesores encargados
  c4: Lista de numeros de cuenta de alumnos participantes

ESPECIFICACIONES:
  LOS ARCHIVOS CON LA INFOMACION DE PROFESORES, ESTUDIANTES Y PROYECTOS SE ALOJARAN EN EL DIRECTORIO
  info CON LOS NOMBRES info_dgapa.cvs ,  info_siae.csv , info_proy.csv
  
  LOS REGISTROS PUEDEN ESTAR DUPLICADOS POR LO QUE AL MOMENTO DE CARGAR LA INFORMACION SE DEBE VERIFICAR
  LA EXISTENCIA DE ALGUN PROFESOR O ESTUDIANTE Y ESCRIBIRSE EN EL ARCHIVO eer_uplicados.csv
  
  LOS ARCHIVOS PUEDEN CONTENER REGISTROS INCOMPLETOS Y SE ESCRIBIRA EL REGISTRO INCOMPLETO EN EL ARCHIVO eer_incompletos.csv
  
  


