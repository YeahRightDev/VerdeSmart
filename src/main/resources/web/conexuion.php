<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // 1. Conexión a BD
    $conn = new mysqli("localhost", "root", "", "nombre_de_tu_bd");
    $data = json_decode(file_get_contents("php://input"), true);
    $nombre = preg_replace('/[^a-zA-Z0-9_\-]/', '', $data['nombre']);

    // 2. Definir la ruta exacta en tu OneDrive
    // Esto busca la carpeta "tus_proyectos" en la misma ubicación que tu archivo PHP
    $carpeta = "tus_proyectos/"; 

    // Asegurarse de que exista
    if (!file_exists($carpeta)) {
        mkdir($carpeta, 0777, true);
    }

    $rutaCompleta = $carpeta . $nombre . ".json";
    file_put_contents($rutaCompleta, json_encode($data));
    
    // Asegurarse de que la carpeta exista
    if (!file_exists($carpeta)) mkdir($carpeta, 0777, true);
    
    // 3. Guardar el archivo JSON
    $rutaArchivo = $carpeta . $nombre . ".json";
    file_put_contents($rutaArchivo, json_encode($data));

    // 4. Guardar en SQL
    $areaTotal = isset($data['areaTotal']) ? $data['areaTotal'] : 0;
    $stmt = $conn->prepare("INSERT INTO proyectos (nombre_proyecto, area_total, ruta_archivo) VALUES (?, ?, ?)");
    $stmt->bind_param("sds", $nombre, $areaTotal, $rutaArchivo);
    $stmt->execute();
    
    echo "Guardado con éxito en: " . $rutaArchivo;
    exit; 
}
?>