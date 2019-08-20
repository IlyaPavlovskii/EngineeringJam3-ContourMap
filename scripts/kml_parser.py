import json
import os
import os.path
import argparse
import random
import xml.etree.ElementTree as ET

LINE_BORDER_COLOR = "ff748296"

SELECTED_COLOR = "8801c4df"
SELECTED_COLOR = "88dfc401"

WRONG_COLOR = "88fe6767"
WRONG_COLOR = "886767fe"

CORRECT_COLOR = "8801df5a"
CORRECT_COLOR = "885adf01"

NOT_SELECTED_COLOR = "<fill>0</fill>"
SELECTED_COLOR = "<color>"+SELECTED_COLOR+"</color>"
CORRECT_COLOR = "<color>"+CORRECT_COLOR+"</color>"
WRONG_COLOR = "<color>"+WRONG_COLOR+"</color>"

POL_DIR_TO_SAVE = "../app/src/main/assets/polygones/reg"
KML_DIR_TO_SAVE = "../app/src/main/assets/kml/reg"

def read_template_file(file_name):
    with open(file_name) as f:
        template_file = f.read()
        return template_file

def save_file(file_content, file_directory, file_name, override = False, to_screen = False):
    if to_screen:
        print '/'*80
        print '=' * 80
        print file_name
        print '=' * 80
        print '/' * 80
        print '\n'
        print file_content
        print '=' * 80
    else:
        if os.path.exists(os.path.join(file_directory, file_name)) and not override:
            # print "\t\tFile %s exists" % (file_name)
            pass
        else:
            if not os.path.exists(file_directory):
                os.makedirs(file_directory)
            with open(os.path.join(file_directory, file_name), "w") as file1:
                file1.write(file_content)

def generate_normal_file(template, name, index, polygon):

    template = template.replace("%%LINE_COLOR%%", LINE_BORDER_COLOR)
    template = template.replace("%%FILL_COLOR%%", NOT_SELECTED_COLOR)
    template = template.replace("%%REGION_NAME%%", name)
    template = template.replace("%%COORDINATES%%", polygon)

    save_file(template, KML_DIR_TO_SAVE, "r_"+str(index)+"_"+name.lower()+".kml", False, False)

def generate_selected_file(template, name, index, polygon):
    template = template.replace("%%LINE_COLOR%%", LINE_BORDER_COLOR)
    template = template.replace("%%FILL_COLOR%%", SELECTED_COLOR)
    template = template.replace("%%REGION_NAME%%", name)
    template = template.replace("%%COORDINATES%%", polygon)

    save_file(template, KML_DIR_TO_SAVE, "r_"+str(index)+"_"+name.lower()+"_selected.kml", False, False)

def generate_correct_file(template, name, index, polygon):
    template = template.replace("%%LINE_COLOR%%", LINE_BORDER_COLOR)
    template = template.replace("%%FILL_COLOR%%", CORRECT_COLOR)
    template = template.replace("%%REGION_NAME%%", name)
    template = template.replace("%%COORDINATES%%", polygon)

    save_file(template, KML_DIR_TO_SAVE, "r_"+str(index)+"_"+name.lower()+"_correct.kml", False, False)


def generate_wrong_file(template, name, index, polygon):
    template = template.replace("%%LINE_COLOR%%", LINE_BORDER_COLOR)
    template = template.replace("%%FILL_COLOR%%", WRONG_COLOR)
    template = template.replace("%%REGION_NAME%%", name)
    template = template.replace("%%COORDINATES%%", polygon)

    save_file(template, KML_DIR_TO_SAVE, "r_"+str(index)+"_"+name.lower()+"_wrong.kml", False, False)


def save_polygin(name, index, polygon):
    save_file(polygon, POL_DIR_TO_SAVE, "p_"+str(index)+"_"+name.lower()+ ".txt", False, False)

def save_map(str_map):
    save_file(str_map, "output/", "map.txt", False, False)

def parse_kml_file():
    tree = ET.parse('data/BLR_adm2.kml')
    root = tree.getroot()

    template = read_template_file("reg_template.kml")

    i = 0
    empty = 0

    str_dict = ""

    all_regions = []
    for plc in root[0][1].iter("{http://www.opengis.net/kml/2.2}Placemark"):
        
        reg_name = ""

        varname_2 = ""
        name_2 = ""
        for dat in plc[1][0]:
            if dat.attrib == {'name': 'VARNAME_2'}:
                varname_2 = dat.text
            if dat.attrib == {'name': 'NAME_2'}:
                name_2 = dat.text


        if varname_2 == "":
            reg_name = name_2
        else:
            reg_name = varname_2

        i+=1
        # print plc[2][0][0][0].text
        reg_polygon = plc[2][0][0][0].text
        str_dict += "%3d - %s\n" % (i, reg_name)

        # print "Pair(GeoObject(%d, \"reg/r_%d_%s.kml\"), \"reg/p_%d_%s.txt\")," % (i, i, reg_name.lower(), i, reg_name.lower())

        short_name = reg_name.lower().replace(' ','_').replace('-','_')
        print "private val %sReg = GeoObject(%d, \"reg/r_%d_%s.kml\")" % (short_name, i, i, reg_name.lower())

        all_regions.append("%sReg" % short_name)

        generate_normal_file(template, reg_name, i, reg_polygon)
        generate_selected_file(template, reg_name,i, reg_polygon)
        generate_wrong_file(template, reg_name,i, reg_polygon)
        generate_correct_file(template, reg_name,i, reg_polygon)
        save_polygin(reg_name, i, reg_polygon)
    
    save_map(str_dict)
    
    # print str_dict

    return all_regions

def get_random_regions(all_regions, answer_reg):

    new_list = [i for i in all_regions]
    new_list.remove(answer_reg)

    regions = random.sample(new_list, k=5)
    regions.append(answer_reg)

    count_asnwer = regions.count(answer_reg)
    if count_asnwer!=1:
        raise Exception("count should be 1")
    answer = ""
    for reg in regions:
        answer +=reg+", "
    
    print "\t\tlistOf("+answer[:-2]+"),"

if __name__ == '__main__':
    all_regions = parse_kml_file()

    for_answer_need_regions = ["mioruReg", "hotimskReg", "puhovichiReg", "polotskReg", "voronovoReg", "khoinikiReg", "chashnikiReg", "korelichiReg", "luninetsReg", "vileykaReg", "soligorskReg"]
    index = 0
    for answer_reg in for_answer_need_regions:
        index+=1
        # print "Answer %d" % index
        print "regGeoSelectorTaskDescription("
        print "\tregGeoSelectorQuiz("
        print "\t\tR.string.geo_selector_quiz_question_%d," % (index + 10)
        get_random_regions(all_regions, answer_reg)
        print "\t\t"+answer_reg
        print "\t)"
        print "),"

    """
    regGeoSelectorTaskDescription(
        regGeoSelectorQuiz(
            R.string.geo_selector_quiz_question_11,
                listOf(brestObl),
                brestObl
            )
        )
    """
        
    print "OK"
